package com.shahenDemoCompose.repository

import android.util.Log
import com.google.gson.Gson
import com.shahenDemoCompose.api.ShahenApiInterface
import com.shahenDemoCompose.di.makeAPICall
import com.shahenDemoCompose.model.request.OrderHistoryCountRequest
import com.shahenDemoCompose.model.response.BaseResponse
import com.shahenDemoCompose.model.response.OrderHistoryCountResponse
import javax.inject.Inject

class OrderHistoryCountRepository @Inject constructor(
    private val shahenApi: ShahenApiInterface
) {

    suspend fun callApiOrderHistoryCount(orderHistoryCountRequest: OrderHistoryCountRequest): BaseResponse<OrderHistoryCountResponse> {
        return makeAPICall {
            shahenApi.orderHistoryCountData(orderHistoryCountRequest)
        }
    }
}