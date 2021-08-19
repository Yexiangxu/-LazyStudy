package com.lazyxu.base.base


import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.ext.getVmClazz


abstract class BaseVmDbFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {

    lateinit var mViewModel: VM

    lateinit var mActivity: AppCompatActivity
    lateinit var mDataBinding: DB




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return mDataBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = createViewModel()
        initView()
        createObserver()
        getData()
        initClicks()
        initHead()

    }
    /**
     * 当前Fragment绑定的视图布局
     */
    abstract fun getLayoutId(): Int

    /**
     * 创建viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }

    /**
     * 初始化view
     */
    abstract fun initView()
    /**
     * 处理所有点击事件
     */
    open fun initClicks(){}


    /**
     * 创建观察者
     */
    abstract fun createObserver()

    /**
     * Fragment执行onCreate后触发的方法
     */
    open fun getData() {}
    /**
     *用来统一设置标题导航栏状态
     */
    private fun initHead() {
        val headToolbar = headToolbar()
    }

    /**
     * 用来统一设置标题导航栏状态
     */
    open fun headToolbar(): HeadToolbar?{
        return null
    }
}