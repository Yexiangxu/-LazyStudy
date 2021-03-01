package com.lazyxu.mvvmlazy.utils

import android.os.Looper


fun isMainThread(): Boolean {
    return Looper.getMainLooper() == Looper.myLooper()
}