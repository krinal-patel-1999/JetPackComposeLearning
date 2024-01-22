package com.quotesAppListing.quotesApp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.quotesAppListing.quotesApp.models.Quote
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.nio.charset.Charset

object DataManager {

    var currentQuote: Quote? = null
    var currentPages = mutableStateOf(Pages.LISTING)
    var data = emptyArray<Quote>()
    var isDataLoad = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charset.defaultCharset())
        val gson = Gson()
        val jsonData = gson.fromJson(json, JsonObject::class.java)

        // Assuming your JSON structure has a "quotes" field containing an array
        data = gson.fromJson(jsonData.getAsJsonArray("quotes"), Array<Quote>::class.java)
       // data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoad.value = true
    }

    fun switchPages(quote: Quote?){
        if (currentPages.value == Pages.LISTING){
            currentQuote = quote
            currentPages.value = Pages.DETAIL
        }else{
            currentPages.value = Pages.LISTING
        }
    }

}