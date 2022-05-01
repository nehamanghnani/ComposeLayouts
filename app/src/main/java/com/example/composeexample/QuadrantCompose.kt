package com.example.composeexample

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexample.ui.theme.ComposeExampleTheme

class QuadrantCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                ComposeQuadrant()
            }
        }
    }
}

@Composable
fun ComposeQuadrant() {
    Surface( modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background) {
        Row(Modifier.fillMaxSize(1f)){
            Column(Modifier.weight(0.5f,true)) {

                    BoxContent(
                        title = "Text composable",
                        content = "Displays text and follows Material Design guidelines.",
                        backgroundColor = Color.Green,
                        height = 0.5f
                        /*,
                        boxModifier = Modifier.align(Alignment.TopStart) */
                    )

                    BoxContent(
                        title = "Row composable",
                        content = "A layout composable that places its children in a horizontal sequence.",
                        backgroundColor = Color.Cyan,

                    )


            }
            Column(Modifier.weight(0.5f,true)) {

                    BoxContent(
                        title = "Image composable",
                        content = "Creates a composable that lays out and draws a given Painter class object.",
                        backgroundColor = Color.Yellow,
                        height = 0.5f
                    )

                    BoxContent(
                        title = "Column composable",
                        content = "A layout composable that places its children in a vertical sequence.",
                        backgroundColor = Color.LightGray
                    )

            }
        }
    }

}

@Composable
fun BoxContent(title : String , content : String, backgroundColor : Color, height:Float = 1f) {
        Surface(color = backgroundColor) {
            Column(modifier = Modifier
                .padding(16.dp).fillMaxHeight(height),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(text = title,
                    fontWeight = Bold,
                    modifier = Modifier.padding(bottom = 16.dp))

                Text(text = content,
                        textAlign = TextAlign.Justify)

            }
        }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun BoxPreview() {
    ComposeExampleTheme {
        BoxContent(title = "Title", content = "content", backgroundColor = Color.Red)
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun AllQuadrantPreview() {
    ComposeExampleTheme {
        ComposeQuadrant()
    }
}