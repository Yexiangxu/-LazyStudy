package com.lazyxu.network

import com.lazyxu.network.entity.Daily
import com.lazyxu.network.entity.Discovery
import com.lazyxu.network.entity.HomePageRecommend
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * 主页界面，主要包含：（首页，社区，通知，我的）对应的 API 接口。
 *
 * @author vipyinzhiwei
 * @since  2020/5/15
 */
interface MainPageService {

    /**
     * 首页-发现列表
     */
    @GET
    suspend fun getDiscovery(@Url url: String): Discovery

    /**
     * 首页-推荐列表
     */
    @GET
    suspend fun getHomePageRecommend(@Url url: String): HomePageRecommend

    /**
     * 首页-日报列表
     */
    @GET
    suspend fun getDaily(@Url url: String): Daily
}