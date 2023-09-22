package com.example.newsapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.MockData
import com.example.newsapp.MockData.getTimeAgo
import com.example.newsapp.NewsData
import com.example.newsapp.R
import com.example.newsapp.models.TopNewsArticles

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController:NavController, article: TopNewsArticles, scrollState: ScrollState) {
    Scaffold(topBar ={
        DetailTopAppBar {
            onBackPressed(navController)
        }
    }) {
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Detail Screen", fontWeight = FontWeight.SemiBold)

            com.skydoves.landscapist.coil.CoilImage(imageModel = article.urlToImage,
                contentScale = ContentScale.Crop,
                error = ImageBitmap.imageResource(id = R.drawable.breaking_news),
                placeHolder = ImageBitmap.imageResource(id = R.drawable.breaking_news))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                InfoWithIcon(icon = Icons.Default.Edit, info = article.author?:"Not Available")
                InfoWithIcon(icon = Icons.Default.DateRange, info = MockData.stringToDate(article.publishedAt!!).getTimeAgo())
            }
            Text(
                text = article.title!!,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Text(text = article.description!!, modifier = Modifier.padding(8.dp))


        }
    }
}

@Composable
fun DetailTopAppBar(onBackPressed:()->Unit){
    TopAppBar(title = { Text(text = "Details Screen" , fontWeight = FontWeight.SemiBold)},
        navigationIcon = {
            IconButton(onClick = { onBackPressed()}) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        })
}

fun onBackPressed(navController: NavController){
    navController.popBackStack()
}

@Composable
fun InfoWithIcon(icon:ImageVector, info:String){
    Row{
        Icon(imageVector = icon, contentDescription ="Author", modifier = Modifier.padding(2.dp),
            colorResource(id = R.color.purple_500))
        Text(text = info, modifier = Modifier.padding(2.dp))
    }

}
@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    DetailScreen(rememberNavController(),TopNewsArticles(author = "Namita", title = "Joseph does his Job",
        description = "Joseph Maldonado, Tiger King, Joe exotic news says that he has been diagnosed with aggressive disease",
        publishedAt = "2022-06-04T05:35:21"), rememberScrollState())
}