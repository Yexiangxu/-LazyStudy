package com.lazyxu.user

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val testLiveData = MutableLiveData<String>()
    fun getTestStr() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("CoroutineScopeTag", "launch ${Thread.currentThread().name}")
            delay(80000)
            Log.d("CoroutineScopeTag", "testLiveData.postValue")
            testLiveData.postValue("我在测试")
        }
    }
}