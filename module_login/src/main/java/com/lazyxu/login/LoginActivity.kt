package com.lazyxu.login

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.base.BaseVmDbActivity
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.login.databinding.ActivityLoginBinding


@Route(path = RouterUrl.User.LOGIN)
class LoginActivity :
    BaseVmDbActivity<LoginViewModel, ActivityLoginBinding>()//, CoroutineScope by MainScope()
{

    override fun layoutId() = R.layout.activity_login
    override fun initView() {

    }

    override fun initClicks() {

        mDataBinding.btnLogin.setOnClickListener {
            ARouter.getInstance().build(RouterUrl.Film.FILM).navigation()
        }
    }

    override fun getData() {
        mViewModel.getLoginInfo()
    }

    override fun createObserver() {
        mViewModel.loginLiveData.observe(this, {

        })
    }


}