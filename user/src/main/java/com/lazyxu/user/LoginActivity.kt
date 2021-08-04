package com.lazyxu.user

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.lazyxu.base.base.BaseActivity
import com.lazyxu.base.base.head.HeadBuild
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.user.databinding.ActivityLoginBinding
import kotlinx.coroutines.*


@Route(path = RouterUrl.User.LOGIN)
class LoginActivity : BaseActivity() {
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }
    private lateinit var databinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        viewModel.getTestStr()
        viewModel.testLiveData.observe(this, observer)
        databinding.btnLogin.setOnClickListener {
            Log.d("CoroutineScopeTag", "跳转")
            finish()
        }
    }

    private val observer = Observer<String> { Log.d("CoroutineScopeTag", "it=$it") }

    override fun headToolbar(): HeadToolbar {
        return HeadBuild().toolbarTitle(R.string.login).create()
    }

    override fun initView() {
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            suspendingGetImage()
        }
    }


    suspend fun suspendingGetImage() = withContext(Dispatchers.IO) {

    }
}