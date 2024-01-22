package com.quotesAppListing.quotesApp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quotesAppListing.quotesApp.screens.QuoteDetailScreen
import com.quotesAppListing.quotesApp.screens.QuoteListScreen
import com.quotesAppListing.quotesApp.ui.theme.JetPackComposeLearningTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuotesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            CoroutineScope(Dispatchers.IO).launch {
                delay(10000)
                DataManager.loadAssetsFromFile(applicationContext)
            }
        setContent {
          // QuotesList(data = ) {
                App()
           }
        }
    }




@Composable
fun App(){
  if (DataManager.isDataLoad.value)  {

      if (DataManager.currentPages.value == Pages.LISTING){
          QuoteListScreen(data = DataManager.data) {
                
              DataManager.switchPages(it)

          }
      }else{
          DataManager.currentQuote?.let { QuoteDetailScreen(quote = it) }
      }


  }
    else{
        Box(
           // contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f))
        Text(text = "Loading.....")
  }
}


enum class Pages{
    LISTING,
    DETAIL
}