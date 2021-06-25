package com.lazyxu.film

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.base.BaseActivity
import com.lazyxu.base.base.head.HeadBuild
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.film.databinding.ActivityFilmBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

@Route(path = RouterUrl.Film.FILM)
class FilmActivity : BaseActivity() {
    private lateinit var databinding: ActivityFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding=DataBindingUtil.setContentView(this,R.layout.activity_film)
        databinding.btnFilm.setOnClickListener {
            ARouter.getInstance().build(RouterUrl.User.LOGIN).navigation()
//            2.random(3)
        }
    }

    override fun headToolbar(): HeadToolbar {
        return HeadBuild().toolbarTitle("电影").create()
    }

    override fun initView() {

    }


    private val list = arrayOf(1..100)

    private fun takeValue() {
        lifecycleScope.launch {
            launch(Dispatchers.IO) {
                for (i in 0..50) {
                    delay(2.random(3)) // 延时0.15秒发送
                    Log.d("TestTag", "send=$i")
                }
            }
        }
    }

    private var randomTime = arrayListOf<Long>()

    private fun Int.random(end: Int): Long {
        if (randomTime.isNullOrEmpty()) {
            val random =  Random().nextInt(end - this+1)+this//去start和end中间随机数
            Log.d("TestTag", "random=$random")
            for (i in 1..random) {
                randomTime.add(2000L)
            }
            randomTime.add(5000L)
        }
        val delayTime = randomTime[0]
        randomTime.removeAt(0)
        return delayTime
    }
}