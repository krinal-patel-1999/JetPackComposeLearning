@file:OptIn(ExperimentalMaterial3Api::class)

package com.tweetesAppWithMVVMAndFlow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tweetesAppWithMVVMAndFlow.api.TweetsyApi
import com.tweetesAppWithMVVMAndFlow.screen.CategoryScreen
import com.tweetesAppWithMVVMAndFlow.screen.DetailScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class TweetsyAppActivity : ComponentActivity() {

    @Inject
    lateinit var tweetsyApi: TweetsyApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*GlobalScope.launch {
            var response = tweetsyApi.getCategories()
            Log.d("KrinalTweet",response.body().toString())
        }*/

        setContent {
            
            Scaffold(
                topBar = {
                    TopAppBar(title = {
                        Text(text = "Tweetsy")
                    },Modifier.background(Color.Black))
                }
            ) {

                Box(modifier = Modifier.padding(it)){
                    App()
                }
                
            }
            

        }
    }
}

// code for navigation
@Composable
fun App(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category"){
        composable(route = "category"){
            CategoryScreen(onClick = {
                 navController.navigate("detail/${it}")
            })
        }

        composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )

            ){
            DetailScreen()
        }
    }

}

