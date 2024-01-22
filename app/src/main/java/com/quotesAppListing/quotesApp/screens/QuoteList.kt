package com.quotesAppListing.quotesApp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quotesAppListing.quotesApp.models.Quote


@Composable
fun QuoteList(data:Array<Quote>, onClick: (quote: Quote)-> Unit) {

    LazyColumn(content = {
        items(data){
            QuotesListitem(quote = it,onClick)
        }
    })
}