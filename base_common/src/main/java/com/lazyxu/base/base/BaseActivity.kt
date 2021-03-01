package com.lazyxu.base.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.utils.ActivityStack

abstract class BaseActivity : AppCompatActivity() {
    private var mLayoutId: Int = -1
    private var mToolbarTitle: Any? = null
    private var mBackDrawable: Int = -1
    private var mToolbarTitleColor: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isTaskRoot) { //防止首次安装按home键重新启动
            val intent = intent
            val action = intent.action
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && action == Intent.ACTION_MAIN) {
                finish()
                return
            }
        }
        ActivityStack.INSTANCE.addActivity(this)
        ARouter.getInstance().inject(this)
        initHead()
    }

    private fun initHead() {
        val headToolbar = headToolbar()
        mLayoutId = headToolbar.layoutId
        //这里设置 mToolbarTitle 必须要使用通用标题的toolbar，若个别页面不使用include的toolbar则不能在这里设置 mToolbarTitle
        mToolbarTitle = headToolbar.toolbarTitle
        mBackDrawable = headToolbar.backDrawable
        mToolbarTitleColor = headToolbar.toolbarTitleColor
    }

    abstract fun headToolbar(): HeadToolbar
}