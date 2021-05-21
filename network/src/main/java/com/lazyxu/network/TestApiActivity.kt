package com.lazyxu.network

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TestApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: GitHubService =
            retrofit.create(GitHubService::class.java)//create为retrofit最核心代码，不长开，减少反射

        val repos: Call<List<Repo>> = service.listRepos("octocat")

        repos.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                Log.d("ApiTestTag", "${response.body()!![0].name}")

            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
            }
        })
    }

    private fun testOkhttp(url: String) {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url(url)
            .build()
        val response=client.newCall(request).execute()


        response.body!!.string()
        //链式工作 插拔器

    }
}