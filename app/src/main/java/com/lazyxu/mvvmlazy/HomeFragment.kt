//package com.lazyxu.mvvmlazy
//
//import android.content.Context
//import android.graphics.Color
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.GridLayoutManager
//import com.lazyxu.mvvmlazy.utils.ScaleTransitionPagerTitleView
//import kotlinx.android.synthetic.main.fragment_home.*
//import net.lucode.hackware.magicindicator.ViewPagerHelper
//import net.lucode.hackware.magicindicator.buildins.UIUtil
//import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
//import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
//import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
//import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
//import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator
//import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView
//
//
//class HomeFragment : Fragment() {
//    private val viewModel: HomeViewModel by lazy {
//        ViewModelProvider(this).get(HomeViewModel::class.java)
//    }
//    private val mainTopAdapter by lazy {
//        HomeTopAdapter()
//    }
//    private val images = mutableListOf(
//            R.drawable.default_home1,
//            R.drawable.default_home2,
//            R.drawable.default_home3,
//            R.drawable.default_home4,
//            R.drawable.default_home2,
//            R.drawable.default_home3,
//            R.drawable.default_home4,
//            R.drawable.default_home2,
//            R.drawable.default_home3,
//            R.drawable.default_home4,
//            R.drawable.default_home2,
//            R.drawable.default_home3,
//            R.drawable.default_home4,
//            R.drawable.default_home2,
//            R.drawable.default_home3,
//            R.drawable.default_home4)
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        rvMainTop.apply {
//            layoutManager = GridLayoutManager(activity, 2)
//            adapter = mainTopAdapter
//
//        }
//        mainTopAdapter.setNewInstance(images)
//        mainTopAdapter.setOnItemClickListener { adapter, view, position ->
//            Toast.makeText(activity, "点击了$position", Toast.LENGTH_SHORT).show()
//        }
//        mainViewPager.adapter = HomePageAdapter(childFragmentManager, mDataList)
//        initMagicIndicator()
//    }
//
//    private val mDataList = arrayOf("热门", "豪车美女", "光圈", "风景")
//    private fun initMagicIndicator() {
//        mainMagicIndicator.setBackgroundColor(Color.parseColor("#f7f7f7"))
//        val commonNavigator = CommonNavigator(activity)
//        commonNavigator.isAdjustMode = true
//        commonNavigator.adapter = object : CommonNavigatorAdapter() {
//            override fun getCount(): Int {
//                return mDataList?.size ?: 0
//            }
//
//            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
//                val simplePagerTitleView: SimplePagerTitleView = ScaleTransitionPagerTitleView(context)
//                simplePagerTitleView.text = mDataList[index]
//                simplePagerTitleView.textSize = 16f
//                simplePagerTitleView.normalColor = Color.GRAY
//                simplePagerTitleView.selectedColor = Color.parseColor("#ff121212")
//                simplePagerTitleView.setOnClickListener { mainViewPager.currentItem = index }
//                return simplePagerTitleView
//            }
//
//            override fun getIndicator(context: Context): IPagerIndicator {
//                val indicator = WrapPagerIndicator(context)
//                indicator.horizontalPadding = UIUtil.dip2px(context, 18.0)
//                indicator.fillColor = Color.parseColor("#fee50e")
//                return indicator
//            }
//        }
//        mainMagicIndicator.navigator = commonNavigator
//        ViewPagerHelper.bind(mainMagicIndicator, mainViewPager)
//    }
//
//}