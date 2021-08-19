package com.lazyxu.base.base

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.Process
import android.provider.Settings
import android.text.TextUtils
import android.webkit.WebView
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.BuildConfig
import com.lazyxu.base.R
import com.lazyxu.base.Weak
import com.lazyxu.base.utils.DeviceUtil
import com.lazyxu.base.utils.MyCrashHandler
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.tencent.bugly.crashreport.CrashReport
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException


abstract class BaseApplication : Application() {

    companion object {
        var INSTANCE by Weak<Application>()
        var refWatcher: RefWatcher? = null
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initSdk()
    }

    private fun initSdk() {
        if (BuildConfig.DEBUG) {
            com.facebook.stetho.Stetho.initializeWithDefaults(this)
            Logger.addLogAdapter(AndroidLogAdapter())
            MyCrashHandler.getInstance().init(this)
            refWatcher = LeakCanary.install(this)
        }
        if (isMainProcess()) {
            //Bugly  为了保证运营数据的准确性，建议不要在异步线程初始化Bugly
            val deviceID = resources.getStringArray(R.array.developDeviceId)
            val myId = Settings.System.getString(contentResolver, Settings.Secure.ANDROID_ID)
            if (!TextUtils.isEmpty(myId)) {
                for (mID in deviceID) {
                    if (mID == myId) {
                        CrashReport.setIsDevelopmentDevice(this, true)//设置调试设备（初始化Bugly之前）
                        break
                    }
                }
            }
            val strategy = CrashReport.UserStrategy(this)
            strategy.appVersion = DeviceUtil.VERSION //strategy.appReportDelay = 10_000
            strategy.appChannel = BuildConfig.CHANNEL_QID
            CrashReport.initCrashReport(
                INSTANCE,
                BuildConfig.BUGLY_APPID,
                BuildConfig.DEBUG,
                strategy
            )
            //ARouter
            if (BuildConfig.DEBUG) {
                ARouter.openLog()    // 打印日志
                ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            }
            ARouter.init(INSTANCE)

        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                WebView.setDataDirectorySuffix(getProcessName(Process.myPid()))
            }
        }


        //LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }

    }

    private fun isMainProcess(): Boolean {
        val processName = getProcessName(Process.myPid())
        return processName == packageName
    }

    private fun getProcessName(pid: Int): String {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(FileReader("/proc/$pid/cmdline"))
            var processName = reader.readLine()
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim { it <= ' ' }
            }
            return processName
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            try {
                reader?.close()
            } catch (exception: IOException) {
                exception.printStackTrace()
            }
        }
        return ""
    }

}