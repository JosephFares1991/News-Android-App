package com.example.newsapp.network

import android.util.Log
import androidx.compose.runtime.*
import com.example.newsapp.models.ArticleCategory
import com.example.newsapp.models.TopNewsResponse
import com.example.newsapp.models.getArticleCategory
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class NewsManager {
    private val _newsResponse = mutableStateOf(TopNewsResponse())
    val newsResponse : State<TopNewsResponse>
    @Composable get() = remember {
        _newsResponse
    }

    private val _getArticlesByCategory = mutableStateOf(TopNewsResponse())
    val getArticlesByCategory : MutableState<TopNewsResponse>
        @Composable get() = remember {
            _getArticlesByCategory
        }

    private val _getArticlesBySource = mutableStateOf(TopNewsResponse())
    val getArticlesBySource : MutableState<TopNewsResponse>
        @Composable get() = remember {
            _getArticlesBySource
        }

    val sourceName = mutableStateOf("abc-news")

    val selectedCategory:MutableState<ArticleCategory?> = mutableStateOf(null)

    init {
        getArticles()
    }

    private fun getArticles(){
        val service = Api.retrofitService.getTopArticles("us")
        service.enqueue(object :retrofit2.Callback<TopNewsResponse>{
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if(response.isSuccessful){
                    _newsResponse.value = response.body()!!
                    Log.d("news", "${_newsResponse.value}")
                }else{
                    Log.d("error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("error", "${t.printStackTrace()}")
            }

        })
    }

    fun getArticlesByCategory(category: String){
        val service = Api.retrofitService.getTopArticlesByCategory(category)
        service.enqueue(object :retrofit2.Callback<TopNewsResponse>{
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if(response.isSuccessful){
                    _getArticlesByCategory.value = response.body()!!
                    Log.d("category", "${_getArticlesByCategory.value}")
                }else{
                    Log.d("error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("error", "${t.printStackTrace()}")
            }

        })
    }

    fun getArticlesBySource(){
        val service = Api.retrofitService.getArticlesBySources(sourceName.value)
        service.enqueue(object :retrofit2.Callback<TopNewsResponse>{
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if(response.isSuccessful){
                    _getArticlesBySource.value = response.body()!!
                    Log.d("source", "${_getArticlesBySource.value}")
                }else{
                    Log.d("error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("error", "${t.printStackTrace()}")
            }

        })
    }


    fun onSelectedCategoryChanged(category: String){
        val newCategory = getArticleCategory(category)
        selectedCategory.value = newCategory
    }
}

