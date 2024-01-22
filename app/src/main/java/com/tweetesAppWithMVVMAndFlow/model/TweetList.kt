package com.tweetesAppWithMVVMAndFlow.model


import com.google.gson.annotations.SerializedName

data class TweetList(
    @SerializedName("tweets")
    var tweets: List<Tweet>
) {
    data class Tweet(
        @SerializedName("category")
        var category: String,
        @SerializedName("text")
        var text: String
    )
}