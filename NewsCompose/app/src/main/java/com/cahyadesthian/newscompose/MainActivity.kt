package com.cahyadesthian.newscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.cahyadesthian.newscompose.model.News
import com.cahyadesthian.newscompose.repository.NewsRepository
import com.cahyadesthian.newscompose.ui.theme.NewsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {

                    val newsList = NewsRepository.getAll()

                    Column() {
                        Header()
                        NewsList(newsList = newsList)
                    }


                }
            }
        }
    }
}

@Composable
fun Header() {

    /*
    * Box ini kaya container kalo di html
    * a.k.a wrapper
    * */
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.width(160.dp),
            painter= rememberAsyncImagePainter("https://static.wikia.nocookie.net/logopedia/images/7/75/Google_News_2015.png/revision/latest?cb=20160220081235"),
            contentDescription= "Logo App",
        )
    }
}


@Composable
fun NewsList(newsList: List<News>) {

    LazyColumn {
        items(newsList.size) {
            //news row
            NewsListItem(newsList[it])
        }
    }


}


@Composable
fun NewsListItem(news: News) {

    Box(
        modifier = Modifier.padding(16.dp),
    ) {

        Row() {
            //Left side - News Info
            Column(
                modifier = Modifier
                    .weight(3f)
            ) {

            }

            //Right side -News Image
            Image(
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .weight(1f),

                painter = rememberAsyncImagePainter(news.imageUrl ),
                contentDescription = "News Image",
                contentScale = ContentScale.Crop
            )
        }


    }

}
