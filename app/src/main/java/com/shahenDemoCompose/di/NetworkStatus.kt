package com.shahenDemoCompose.di

import android.accounts.NetworkErrorException
import com.shahenDemoCompose.model.response.BaseResponse
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> makeAPICall(call:suspend () -> Response<T>): BaseResponse<T> {
    return try {
        val response = call.invoke()

        when {
            response.code() == 200 -> {
                BaseResponse.Success(response.body())
            }

            response.code() == 422 -> {

                //response.errorBody.string() convert into LoginErrorValidationResponse
                BaseResponse.Error(response.message(), response.code(),response.errorBody())

            }

            else ->
                BaseResponse.Error("Other error")
        }
    }
    catch (e: Exception) {
        return if (e is SocketTimeoutException ||
            e is UnknownHostException ||
            e is IOException ||
            e is NetworkErrorException
        ) {
            BaseResponse.Error(e.message)
        } else {
            BaseResponse.Error(e.message)
        }
    }
}