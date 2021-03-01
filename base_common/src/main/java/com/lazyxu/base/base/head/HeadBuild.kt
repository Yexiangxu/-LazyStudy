package com.lazyxu.base.base.head

class HeadBuild : IHeadBuilder {
    var headToolbar = HeadToolbar()
    override fun contentViewId(layoutId: Int): IHeadBuilder {
        headToolbar.layoutId = layoutId
        return this
    }
    override fun toolbarTitle(toolbarTitle: Any): IHeadBuilder {
        headToolbar.toolbarTitle = toolbarTitle
        return this
    }
    override fun toolbarTitleSize(textSize: Int): IHeadBuilder {
        headToolbar.toolbarTitleSize = textSize
        return this
    }

    override fun toolbarTitleColor(toolbarTitleColor: Int): IHeadBuilder {
        headToolbar.toolbarTitleColor = toolbarTitleColor
        return this
    }

    override fun toolbarBgColor(toolbarBgColor: Int): IHeadBuilder {
        headToolbar.toolbarBgColor = toolbarBgColor
        return this
    }

    override fun backDrawable(backDrawable: Int): IHeadBuilder {
        headToolbar.backDrawable = backDrawable
        return this
    }

    override fun statusBarColor(statusBarColor: Int): IHeadBuilder {
        headToolbar.statusBarColor = statusBarColor
        return this
    }

    override fun hideBack(hideBack: Boolean): IHeadBuilder {
        headToolbar.isHideBack = hideBack
        return this
    }

    override fun create(): HeadToolbar {
        return headToolbar
    }
}