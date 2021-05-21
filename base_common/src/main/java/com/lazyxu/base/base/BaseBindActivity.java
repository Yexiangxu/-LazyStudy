package com.lazyxu.base.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseBindActivity<DB extends ViewDataBinding> extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DB db = DataBindingUtil.setContentView(this, getLayoutId());
        initView(db);
    }

    /**
     * 获取资源ID
     *
     * @return 布局资源ID
     */
    protected abstract int getLayoutId();

    /**
     * 初始化界面
     * @param bindView 界面绑定对象
     */
    protected abstract void initView(DB bindView);
}
