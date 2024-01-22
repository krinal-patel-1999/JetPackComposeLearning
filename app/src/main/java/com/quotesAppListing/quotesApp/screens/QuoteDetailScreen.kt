package com.quotesAppListing.quotesApp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.quotesAppListing.quotesApp.DataManager
import com.quotesAppListing.quotesApp.models.Quote

@Composable
fun QuoteDetailScreen(quote: Quote) {
    
    BackHandler() {
      DataManager.switchPages(null)
    }
    

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
    ) {

        Card(modifier = Modifier.padding(32.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            )) {

            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    // .align(Alignment.Center)
                    .padding(16.dp,24.dp)
            ){


                Image(
                    imageVector = Icons.Filled.FormatQuote, contentDescription = "Quotes",
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180f)
                )


                Text(
                    text = quote.quote,
                    // fontFamily = FontFamily(Font(R.font.manrope_medium)),
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.titleLarge,
                    //fontFamily =  FontFamily(Font(R.font.manrope))

                )

            }

        }

    }

}