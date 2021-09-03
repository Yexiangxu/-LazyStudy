package com.lazyxu.lazystudy

import android.os.Bundle
import android.os.FileUtils
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.lazystudy.databinding.ActivityMainBinding
import java.io.File
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    private lateinit var databinding: ActivityMainBinding

    //    private var wallpaperFragment: HomeFragment? = null
//    private var musicFragment: MineFragment? = null
//    private var myFragment: HomeFragment? = null
//    private var myFragment4: HomeFragment? = null
//    private var myFragment5: HomeFragment? = null
//    private var mFragments: MutableList<Fragment> = mutableListOf()
//    private var lastIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ARouter.getInstance().build(RouterUrl.Film.FILM).navigation()

        try {
            val str="Icd2cGCWtP+3ILAn45+C4Nc/gFDutyGohEp7r2E1SNVY1ArdsCxWdTzXSiA="
//            Log.i("LogTagTest","str=$str")
            val base64=RC4Utils.Base64Decode(str)
            Log.i("LogTagTest","base64=$base64")
            val test = RC4Utils.HloveyRC4(base64, "k8ShsXZR20Ujc9QP")
            Log.i("LogTagTest", "test=$test")


//            val strings = "{\"state\":1,\"set_time\":\"120\",\"no_init\":[\"4\"]}"
//
////          val rc4 =   RC4Utils.HloveyRC4("{\"state\":1,\"set_time\":\"120\",\"no_init\":[\"4\"]}", "k8ShsXZR20Ujc9QP")
//
//
//            val rc4Utils =   com.lazyxu.lazystudy.utils.RC4Utils("k8ShsXZR20Ujc9QP".toByteArray(Charset.forName("UTF-8")))
//
//            val result =   rc4Utils.encrypt(strings.toByteArray(Charset.forName("UTF-8")))
//
//
//            Log.i("LogTagTest", "result=${result.toString(Charset.forName("UTF-8"))}")
//
//            val b64 =  Base64.encode(result, Base64.NO_WRAP)
//
//            val res= b64.toString(Charset.forName("UTF-8"))
//            Log.i("LogTagTest", "b64=$res")



            val b642 = Base64.decode(str.toByteArray(),Base64.NO_WRAP)

            Log.i("LogTagTest", "b642=${b642}")
            val rc4Utils2 =   com.lazyxu.lazystudy.utils.RC4Utils("k8ShsXZR20Ujc9QP".toByteArray())
            val rc4 =  rc4Utils2.decrypt(b642)


            Log.i("LogTagTest", "rc4=${rc4.toString(Charset.forName("UTF-8"))}")

        } catch (e: Exception) {
            Log.i("LogTagTest", "test=$e")
        }
//        initView()
    }
}
//
//    private fun initView() {
//        wallpaperFragment = HomeFragment()
//        musicFragment = MineFragment()
//        myFragment = HomeFragment()
//        myFragment4 = HomeFragment()
//        myFragment5 = HomeFragment()
//        mFragments.add(wallpaperFragment!!)
//        mFragments.add(wallpaperFragment!!)
//        mFragments.add(wallpaperFragment!!)
//        mFragments.add(wallpaperFragment!!)
//        mFragments.add(wallpaperFragment!!)
//        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        setFragmentPosition(0)
//
//    }
//
//
//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        bottomNavigation.menu.forEachIndexed { index, _item ->
//            if (item.itemId == _item.itemId) {
//                setFragmentPosition(index)
//                println("点击了")
//            }
//        }
//        true
//    }
//
//
//    /**
//     * commitAllowingStateLoss 和 commit 区别（尽量用commit）
//     * 比如commit()操作在onSaveInstanceState()之后，可能抛出异常，
//     * 那是不是直接所有都用 commitAllowingStateLoss 好呢？肯定不是
//     *
//     */
//    private fun setFragmentPosition(position: Int) {
//        try {
//            val ft = supportFragmentManager.beginTransaction()
//            val currentFragment = mFragments[position]
//            val lastFragment = mFragments[lastIndex]
//            lastIndex = position
//            ft.hide(lastFragment)
//            if (!currentFragment.isAdded) {
//                supportFragmentManager.beginTransaction().remove(currentFragment).commitAllowingStateLoss()
//                ft.add(R.id.tabNavigation, currentFragment)
//            }
//            ft.show(currentFragment)
//            ft.commitAllowingStateLoss()
//        } catch (e: IndexOutOfBoundsException) {
//        }
//    }
//
//}