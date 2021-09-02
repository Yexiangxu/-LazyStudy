package com.lazyxu.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lazyxu.base.base.BaseViewModel
import com.lazyxu.base.utils.RegexUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel() {
    // 私有的 MutableLiveData 可变的，对内访问
    private val _loginLiveData = MutableLiveData<LoginEntity>()

    // 对外暴露不可变的 LiveData，只能查询
    val loginLiveData: LiveData<LoginEntity> = _loginLiveData
    val testLiveData = MutableLiveData<String>()
    fun getLoginInfo() {
        viewModelScope.launch {
            Log.d("CoroutineScopeTag", "launch ${Thread.currentThread().name}")
            delay(8000)
            testLiveData.postValue("我在测试")
        }
    }

    fun login(phone: String, password: String) {
        val isUsernameValid =RegexUtils.isValidMobile(phone.trim())
        val isPassWordValid = password.trim().length >= 6
    }
}