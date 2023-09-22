package com.example.newsapp.network

import com.example.newsapp.models.TopNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    fun getTopArticles(@Query("country") country:String,
                      ):Call<TopNewsResponse>

    @GET("top-headlines")
    fun getTopArticlesByCategory(@Query("category") category:String,
                                ):Call<TopNewsResponse>

    @GET("everything")
    fun getArticlesBySources(@Query("sources") sources:String):Call<TopNewsResponse>
}