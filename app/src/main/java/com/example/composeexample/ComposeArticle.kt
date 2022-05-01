package com.example.composeexample

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexample.ui.theme.ComposeExampleTheme


class ComposeArticle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            ComposeExampleTheme {
                ComposeArticleDesign()
            }
        }
    }

    @Composable
    fun ComposeArticleDesign() {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {


            Column{

                Image(
                    painter = painterResource(id = R.drawable.bg_compose_background),
                    contentDescription = null
                )

                Column (modifier = Modifier.padding(16.dp)){
                    Text(
                        text = "Jetpack Compose tutorial",
                        fontSize = 24.sp
                    )

                    Text(
                        text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Justify

                    )

                    Text(
                        text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Justify
                    )
                }


            }


        }
    }


    @Preview(showBackground = true, widthDp = 320, heightDp = 320)
    @Preview(showBackground = true, widthDp = 320, heightDp = 320, uiMode = UI_MODE_NIGHT_YES)
    @Composable
    private fun defaultPreview() {
        ComposeExampleTheme {
            ComposeArticleDesign()
        }
    }
}

