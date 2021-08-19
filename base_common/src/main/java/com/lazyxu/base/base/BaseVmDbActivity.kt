package com.lazyxu.base.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.ext.getVmClazz
import com.lazyxu.base.utils.ActivityStack


abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {
    lateinit var mDataBinding: DB
    lateinit var mViewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isTaskRoot) { //防止首次安装按home键重新启动
            val intent = intent
            val action = intent.action
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && action == Intent.ACTION_MAIN) {
                finish()
                return
            }
        }
        ActivityStack.INSTANCE.addActivity(this)
        ARouter.getInstance().inject(this)
        mDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mViewModel = createViewModel()
        initView()
        createObserver()
        getData()
        initClicks()
        initHead()
    }
    /**
     * 创建viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }
    /**
     * 创建LiveData数据观察者
     */
    open fun createObserver() {}

    /**
     * 获取布局，用抽象方法防止漏掉
     */
    abstract fun layoutId(): Int

    /**
     * 初始化view
     */
    abstract fun initView()

    /**
     * 刚进页面需要网络请求等操作
     */
    open fun getData() {}

    /**
     * 处理所有点击事件
     */
    open fun initClicks(){}


    /**
     *用来统一设置标题导航栏状态
     */
    private fun initHead() {
//        val headToolbar = headToolbar()
    }

    /**
     * 用来统一设置标题导航栏状态
     */
    open fun headToolbar(): HeadToolbar?{
        return null
    }
    override fun onDestroy() {
        super.onDestroy()
        ActivityStack.INSTANCE.removeActivity(this)
    }
}