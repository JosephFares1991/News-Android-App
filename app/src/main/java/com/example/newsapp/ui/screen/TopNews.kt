package com.example.newsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.MockData
import com.example.newsapp.R
import com.example.newsapp.MockData.getTimeAgo
import com.example.newsapp.NewsData
import com.example.newsapp.MockData.topNewsList
import com.example.newsapp.models.TopNewsArticles
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun TopNews(navController: NavController, articles:List<TopNewsArticles>){
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Top News", fontWeight = FontWeight.SemiBold)
        LazyColumn{
            items(articles.size){
                    index->
                TopNewsItem(article = articles[index],
                    onNewsClick = {
                       navController.navigate("Detail/${index}")
                    })

            }
        }
    }
}

@Composable
fun TopNewsItem(article:TopNewsArticles, onNewsClick:()->Unit={}){
    Box(modifier = Modifier
        .height(200.dp)
        .padding(8.dp)
        .clickable {
            onNewsClick()
        }) {
        com.skydoves.landscapist.coil.CoilImage(imageModel = article.urlToImage,
            contentScale = ContentScale.Crop,
            error = ImageBitmap.imageResource(id = R.drawable.breaking_news),
            placeHolder = ImageBitmap.imageResource(id = R.drawable.breaking_news),
            modifier = Modifier.fillMaxWidth()
        )
        Column(modifier = Modifier
            .wrapContentHeight()
            .padding(top = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = MockData.stringToDate(article.publishedAt!!).getTimeAgo(), color = Color.White, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(80.dp))
            Text(text = article.title!!, color = Color.White, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopNewsPreview(){
    TopNewsItem(
        TopNewsArticles(author = "Namita", title = "Joseph does his Job",
            description = "Joseph Maldonado, Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
            publishedAt = "2022-06-04T05:35:21"))

}
