package com.example.newsapp.models

data class TopNewsResponse(
    val status:String?=null,
    val totalResults:Int?=null,
    val articles:List<TopNewsArticles>?=null
)
