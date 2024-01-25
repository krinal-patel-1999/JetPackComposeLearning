package com.shahenDemoCompose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.jetpackcomposelearning.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashScreenCompleted: () -> Unit) {
    val animationSpec = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.splash_screen),
        imageAssetsFolder = "images/"

    )

    val progress by animateLottieCompositionAsState(
        composition = animationSpec.value,
        iterations = LottieConstants.IterateForever

    )

    LaunchedEffect(key1 = "progress") {
        // Introduce a delay or check the Lottie animation progress
        delay(4000) // Delay for 5000 milliseconds (5 seconds) as an example

        // Invoke the callback to notify that the splash screen is completed
        onSplashScreenCompleted()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            composition = animationSpec.value,
            progress = progress,
           // modifier = Modifier.size(200.dp),

        )
    }
}

