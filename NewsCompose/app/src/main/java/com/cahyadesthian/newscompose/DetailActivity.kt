package com.cahyadesthian.newscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import com.cahyadesthian.newscompose.repository.NewsRepository
import com.cahyadesthian.newscompose.ui.theme.NewsComposeTheme
import com.cahyadesthian.newscompose.util.DateFormatUtil

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val idSent = intent.getIntExtra("extra_id", -1)
        //val news = NewsRepository.getAll().filter { it.id == idSent }
        //or mau dapat id yang pertama dengan id itu bisa pakai first(instead of filter)
        val news = NewsRepository.getAll().first { it.id == idSent }

        setContent {
            NewsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {

                    Box() {

                      Column(
                          modifier = Modifier.verticalScroll(rememberScrollState())
                      ) {
                          NewsImage(news.imageUrl)
                          NewsTitle(title = news.title)
                          NewsAuthorAndDate(author = news.author, date = news.date)
                          NewsDescription(description = news.description)
                      }


                        //we gonna play with state for chanign our drawable
                        // state itu variable tersendiri jadi mutableStateOf biar bisa ganti drawablenya
                        var isFav by remember { mutableStateOf(false)}

                        FloatingActionButton(
                            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
                            onClick = {
                                isFav = !isFav
                            })
                        {
                            Icon(
                                painter = painterResource(id = if(isFav) R.drawable.ic_fav else R.drawable.ic_favorite_border) ,
                                contentDescription = "fav icon"
                            )
                        }


                    }


                }
            }
        }
    }
}


@Composable
fun NewsImage(imageUrl: String) {

    Image(
        modifier = Modifier
            .aspectRatio(16 / 9f)
            .fillMaxWidth(),
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = "image news",
        contentScale = ContentScale.Crop
    )

}

@Composable
fun NewsTitle(title: String) {

    //news title
    Text(
        modifier = Modifier.padding(16.dp),
        text= title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Black,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2
    )

}

@Composable
fun NewsAuthorAndDate(author: String, date: String) {

    //author and date section
    Row(
        modifier = Modifier.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        //author text
        Text(
            text=author,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.width(4.dp))

        //bullet
        Canvas(
            modifier = Modifier.size(4.dp),
        ) {
            drawCircle(Color.Gray)
        }

        Spacer(modifier = Modifier.width(4.dp))

        //date
        Text(
            //text =news.date,
            text = DateFormatUtil.formatDate(date),
            fontSize = 12.sp
        )



    }


}



@Composable
fun NewsDescription(description: String) {

    var text =""

    repeat(50) {
        text += description
    }

    Text(
        modifier = Modifier.padding(12.dp),
        text = text)
}

