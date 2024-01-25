package com.shahenDemoCompose.api

import com.shahenDemoCompose.model.request.LoginRequest
import com.shahenDemoCompose.model.request.OrderHistoryCountRequest
import com.shahenDemoCompose.model.response.LoginResponse
import com.shahenDemoCompose.model.response.OrderHistoryCountResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ShahenApiInterface {

    @POST("login")
    suspend fun loginData(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("order/history/count")
    suspend fun orderHistoryCountData(@Body orderHistoryCountRequest: OrderHistoryCountRequest) : Response<OrderHistoryCountResponse>


}