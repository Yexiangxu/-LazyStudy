package com.lazyxu.base.base.head

import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes

interface IHeadBuilder {
    fun contentViewId(@LayoutRes layoutId: Int): IHeadBuilder
    fun toolbarTitle( toolbarTitle: Any): IHeadBuilder
    fun toolbarTitleSize(@StringRes textSize: Int): IHeadBuilder
    fun toolbarTitleColor(@ColorRes toolbarTitleColor: Int): IHeadBuilder
    fun toolbarBgColor(@ColorRes toolbarBgColor: Int): IHeadBuilder
    fun backDrawable(@ColorRes backDrawable: Int): IHeadBuilder
    fun statusBarColor(@ColorRes statusBarColor: Int): IHeadBuilder
    fun hideBack(hideBack: Boolean): IHeadBuilder
    fun create(): HeadToolbar
}