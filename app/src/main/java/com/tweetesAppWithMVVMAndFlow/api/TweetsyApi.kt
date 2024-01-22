package com.tweetesAppWithMVVMAndFlow.api

import com.tweetesAppWithMVVMAndFlow.model.TweetList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {
    @GET("/v3/b/65ac99c21f5677401f223bfb?meta=false")
   suspend fun getTweets(@Header("X-JSON-Path")category:String) : Response<List<TweetList.Tweet>>

   @GET("/v3/b/65ac99c21f5677401f223bfb?meta=false")
   @Headers("X-JSON-Path: tweets..category")
   suspend fun getCategories(): Response<List<String>>
}