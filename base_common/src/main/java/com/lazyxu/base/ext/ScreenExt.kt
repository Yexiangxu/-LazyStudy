package com.lazyxu.base.ext

import android.content.res.Resources
import android.util.TypedValue

fun Float.dp2px(value: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value, Resources.getSystem().displayMetrics).toInt()
}
fun Int.dp2px(value: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value, Resources.getSystem().displayMetrics).toInt()
}