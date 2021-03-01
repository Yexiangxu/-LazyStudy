package com.lazyxu.base.utils

import android.app.Activity
import android.content.Context
import android.os.Process
import android.view.inputmethod.InputMethodManager
import java.util.*
import kotlin.system.exitProcess

/**
 * User:Lazy_xu
 * Data:2019/10/10
 * FIXME
 */
class ActivityStack private constructor() {
    private var mActivities = Stack<Activity>()

    companion object {
        val INSTANCE: ActivityStack by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { ActivityStack() }
    }

    fun addActivity(activity: Activity) {
        this.mActivities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        with(activity) {
            if (!mActivities.isEmpty() && mActivities.contains(this)) {
                mActivities.remove(this)
                this.finish()
            }
        }
    }

    fun popAllActivity(isForceClose: Boolean) {
        while (this.mActivities.size > 0) {
            this.popActivity()
        }
        if (isForceClose) {
            Process.killProcess(Process.myPid())
            exitProcess(-1)
        }
    }

    private fun popActivity() {
        if (!this.mActivities.isEmpty()) {
            //pop栈顶元素出栈
            (mActivities.pop() as Activity).finish()
        }
    }

    fun popAllActivityExceptTop() {
        while (this.mActivities.size > 1) {
            val activity: Activity = this.mActivities[0] as Activity
            this.mActivities.remove(activity)
            activity.finish()
        }
    }
}
