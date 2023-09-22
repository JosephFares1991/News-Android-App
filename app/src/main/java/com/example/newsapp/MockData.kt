package com.example.newsapp

import android.os.Build
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object MockData {
    val topNewsList = listOf<NewsData>(
        NewsData(1,
            R.drawable.breaking_news,
            "Raja, Razek",
            "Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "Joseph Maldonado, Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "2021-11-04T05:35:21Z"),

        NewsData(2,
            R.drawable.namita,
            "Raja, Razek",
            "Namita, Joe exotic news says that he has been diagnosed with aggressive disease",
            "Joseph Maldonado, Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "2022-12-04T05:35:21"),

        NewsData(3,
            R.drawable.grant,
            "Raja, Razek",
            "Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "Joseph Maldonado, Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "2022-06-04T05:35:21"),


        NewsData(4,
            R.drawable.michael,
            "Raja, Razek",
            "Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "Joseph Maldonado, Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "2023-02-04T05:35:21"),

        NewsData(5,
            R.drawable.nbc_spot,
            "Raja, Razek",
            "Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "Joseph Maldonado, Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "2021-11-04T05:35:21"),

        NewsData(6,
            R.drawable.reuters,
            "Raja, Razek",
            "Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "Joseph Maldonado, Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "2020-11-04T05:35:21"),

        NewsData(7,
            R.drawable.tiger_king,
            "Raja, Razek",
            "Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "Joseph Maldonado, Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            "2021-11-04T05:35:21")
    )

    fun getNewsData(newsID:Int?):NewsData{
        return topNewsList.first { it.id == newsID }
    }
    fun Date.getTimeAgo():String{
        val calender = Calendar.getInstance()
        calender.time = this

        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val hour = calender.get(Calendar.HOUR)
        val minute = calender.get(Calendar.MINUTE)
        val second = calender.get(Calendar.SECOND)

        val currentCalender = Calendar.getInstance()

        val currentYear = currentCalender.get(Calendar.YEAR)
        val currentMonth = currentCalender.get(Calendar.MONTH)
        val currentDay = currentCalender.get(Calendar.DAY_OF_MONTH)
        val currentHour = currentCalender.get(Calendar.HOUR)
        val currentMinute = currentCalender.get(Calendar.MINUTE)
        val currentSecond = currentCalender.get(Calendar.SECOND)

        return if(year<currentYear){
            val interval = currentYear-year
            if(interval == 1) "${interval} year ago" else "${interval} years ago"
        }else if(month<currentMonth){
            val interval = currentMonth-month
            if(interval == 1) "${interval} month ago" else "${interval} months ago"
        }else if(day<currentDay){
            val interval = currentDay-day
            if(interval == 1) "${interval} day ago" else "${interval} days ago"
        }else if(day<currentDay){
            val interval = currentDay-day
            if(interval == 1) "${interval} day ago" else "${interval} days ago"
        }else if(hour<currentHour){
            val interval = currentHour-hour
            if(interval == 1) "${interval} hour ago" else "${interval} hours ago"
        }else if(minute<currentMinute){
            val interval = currentMinute-minute
            if(interval == 1) "${interval} minute ago" else "${interval} minutes ago"
        }else{
            "a moment ago "
        }
    }

    fun stringToDate(publishedAt:String):Date{
        val date =
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.ENGLISH).parse(publishedAt)
            }else {
                java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
                    .parse(publishedAt)
            }
        Log.d("published", "${date}")
        return date
    }
}
