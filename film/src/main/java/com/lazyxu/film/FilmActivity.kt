package com.lazyxu.film

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.base.BaseVmDbActivity
import com.lazyxu.base.base.head.HeadBuild
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.film.databinding.ActivityFilmBinding

@Route(path = RouterUrl.Film.FILM)
class FilmActivity : BaseVmDbActivity<FilmViewModel, ActivityFilmBinding>() {
    override fun layoutId() = R.layout.activity_film


    override fun headToolbar() = HeadBuild().toolbarTitle("电影").create()


    override fun initView() {

    }

    override fun initClicks() {
        mDataBinding.btnFilm.setOnClickListener {
            ARouter.getInstance().build(RouterUrl.User.LOGIN).navigation()
        }
    }


}