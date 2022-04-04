package com.example.composeexample

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
               MyAppDesign()

            }
        }
    }
}

@Composable
fun OnBoardingScreen(onContinueClicked : () -> Unit) {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(text = "Welcome to basics of CodeLab", modifier = Modifier.padding(bottom = 24.dp))

            Button(onClick = onContinueClicked) {
                Text(text = "Continue")
            }
        }

    }
}

@Composable
fun MyAppDesign() {
    var showOnBoarding by rememberSaveable {
        mutableStateOf(true)
    }
    //this if-else condition (or composable, in general) will get re-evaluated when the
    // "showOnBoarding" state changes
    if (showOnBoarding) {
        OnBoardingScreen(onContinueClicked = { showOnBoarding = false} )

    } else {
        Greetings()
    }
}

@Composable
fun Greetings(listNames: List<String> = List(1000) {"$it"}) {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier
        .fillMaxSize()
    ) {
        LazyColumn (Modifier.padding(vertical = 4.dp)){
            item { Text(text = "Heading for items") }
            items(listNames) {
                name -> Greeting(name)
            }
        }
    }
}

@Composable
private fun Greeting(name: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}


@Composable
fun CardContent(name: String) {
    //'remember' will remember the state of this variable so that this value is not re-written
    //when the composable is called again (recomposed) when the data related to it changes
    val expanded = remember {
        mutableStateOf(false)
    }
    val extraPadding by animateDpAsState(
        targetValue =  if (expanded.value) 48.dp else 0.dp,
        animationSpec = tween(1000)

    )
    Surface(color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {

        Row(Modifier
            .padding(24.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello,")
                Text(text = name, style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.Bold
                ))
            }
            OutlinedButton(onClick = {  expanded.value = !expanded.value}) {
                Text(text = if(!expanded.value) "Show more" else "Show less")
            }
        }


    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 320, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeExampleTheme {
        OnBoardingScreen(onContinueClicked = {})
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun DefaultPreview() {
    ComposeExampleTheme {
        Greetings()
    }
}