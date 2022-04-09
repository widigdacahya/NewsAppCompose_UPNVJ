package com.cahyadesthian.introcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.cahyadesthian.introcompose.ui.theme.IntroComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    
                    // Pascal Case untuk nama component -> besar di awal misal FirstName
                    // camelCase untuk attribut
                    Text(
                        text = "Hello Cahya\uD83D\uDE01",
                        color = Color.DarkGray,
                        fontStyle = FontStyle.Italic,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Hai Cahya\uD83D\uDE01",
                        color = Color.DarkGray,
                        fontStyle = FontStyle.Italic,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black
                    )
                    
                    
                }
            }
        }
    }
}

