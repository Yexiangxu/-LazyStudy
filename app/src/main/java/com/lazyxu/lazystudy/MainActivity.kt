package com.lazyxu.lazystudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.lazystudy.databinding.ActivityMainBinding

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