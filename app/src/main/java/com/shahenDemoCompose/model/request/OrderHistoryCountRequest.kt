package com.shahenDemoCompose.model.request


import com.google.gson.annotations.SerializedName

data class OrderHistoryCountRequest(
    @SerializedName("section")
    var section: String
)