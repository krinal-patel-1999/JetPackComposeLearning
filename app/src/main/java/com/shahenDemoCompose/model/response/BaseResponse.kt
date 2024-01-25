package com.shahenDemoCompose.model.response

import okhttp3.ResponseBody

sealed class BaseResponse<out T> {
    data class Success<out T>(val data: T? = null) : BaseResponse<T>()
    data class Loading(val nothing: Nothing?=null) : BaseResponse<Nothing>()
    data class Error(val msg: String?, val code : Int = 0,val errorBody: ResponseBody? = null) : BaseResponse<Nothing>()
    data class ErrorMsg<T>(
        val throwable: Throwable? = null,
        val errorMessage: String? = null,
        val messageCode: String? = null,
        val errorData: Any? = null,
        val errorCode: Int? = null,
        val responseData: T? = null,
    ) : BaseResponse<Nothing>()

}