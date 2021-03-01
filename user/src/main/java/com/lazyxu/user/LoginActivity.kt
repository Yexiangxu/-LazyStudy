package com.lazyxu.user

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.base.BaseActivity
import com.lazyxu.base.base.head.HeadBuild
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.router.RouterUrl


@Route(path = RouterUrl.User.LOGIN)
class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

    override fun headToolbar(): HeadToolbar {
        return HeadBuild().toolbarTitle(R.string.login).create()
    }
}