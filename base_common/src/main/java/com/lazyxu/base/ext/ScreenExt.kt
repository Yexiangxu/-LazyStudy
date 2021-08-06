package com.lazyxu.base.ext

import android.content.res.Resources
import android.util.TypedValue


fun dp2px(value: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value, Resources.getSystem().displayMetrics).toInt()
}

fun Float.dp2px(value: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value, Resources.getSystem().displayMetrics).toInt()
}