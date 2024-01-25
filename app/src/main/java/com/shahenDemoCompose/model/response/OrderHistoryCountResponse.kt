package com.shahenDemoCompose.model.response


import com.google.gson.annotations.SerializedName

data class OrderHistoryCountResponse(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("message")
    var message: String,
    @SerializedName("message_code")
    var messageCode: String,
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("status_code")
    var statusCode: Int,
    @SerializedName("userStatus")
    var userStatus: String
) {
    data class Data(
        @SerializedName("count")
        var count: Int,
        @SerializedName("key")
        var key: String,
        @SerializedName("label")
        var label: String
    )
}