package com.example.newsapp.models

data class TopNewsArticles(
    val source:Source? = null,
    val author:String? = null,
    val title:String? = null,
    val description:String? = null,
    val url:String? = null,
    val urlToImage:String? = null,
    val publishedAt:String? = null,
    val content:String? = null
)