package com.shahenDemoCompose.repository

import android.util.Log
import com.google.gson.Gson
import com.shahenDemoCompose.api.ShahenApiInterface
import com.shahenDemoCompose.di.makeAPICall
import com.shahenDemoCompose.model.request.LoginRequest
import com.shahenDemoCompose.model.response.BaseResponse
import com.shahenDemoCompose.model.response.LoginResponse
import javax.inject.Inject


class LoginRepository @Inject constructor(private  val shahenApi: ShahenApiInterface ) {

    suspend fun callApiLOGIN(loginRequest: LoginRequest): BaseResponse<LoginResponse> {
        Log.e("response", "LoginRequest" + Gson().toJson(loginRequest))
        return makeAPICall {
            shahenApi.loginData(loginRequest)
        }
    }

}