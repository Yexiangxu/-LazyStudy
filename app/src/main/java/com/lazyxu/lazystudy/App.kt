package com.lazyxu.lazystudy

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import com.lazyxu.base.base.BaseApplication
import kotlin.properties.Delegates

class App : BaseApplication() {
    companion object {
        var instance: App by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        //注册activity生命周期

    }

}