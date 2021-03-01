package com.lazyxu.base.utils

import com.lazyxu.base.base.BaseApplication

class DeviceUtil {
    companion object {
        /**
         * 获取版本号
         */
        val VERSION: String by lazy {
            val pm = BaseApplication.INSTANCE.packageManager
            val pi = pm.getPackageInfo(BaseApplication.INSTANCE.packageName, 0)
            val versionName = pi.versionName
            versionName
        }
    }
}
