package com.lazyxu.film

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.base.BaseActivity
import com.lazyxu.base.base.head.HeadBuild
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.router.RouterUrl

@Route(path = RouterUrl.Main.FILM)
class FilmActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)
    }

    override fun headToolbar(): HeadToolbar {
        return HeadBuild().toolbarTitle("电影").create()
    }
}