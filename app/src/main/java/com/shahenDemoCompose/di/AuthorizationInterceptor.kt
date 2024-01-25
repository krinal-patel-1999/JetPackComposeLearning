package com.shahenDemoCompose.di

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMmEyYjNlODNiNzA5ZmY0MzY4OTgxODY5NDI3MjcxNGUzNzhhMGUzOGM4YTUxMzFlNDliNzVkZmMwNTk1NzNiZWVjYzM4NjhhODBkMGE4M2YiLCJpYXQiOjE3MDYwMTY3NDgsIm5iZiI6MTcwNjAxNjc0OCwiZXhwIjoxNzM3NjM5MTQ4LCJzdWIiOiIxNiIsInNjb3BlcyI6W119.CEgZWcg6ejYmUjYxsBzR6zu8GLNOGCA-c0kzkgnFh-VJSrlTttmG4LNO-OahK5zRolms21Ngi0C8EliWfpYRdFZmFq9JvVj3zbTfRHA40SNetjTMbAUNzx0OZn_UI38nDFCzn_A2luBEyFeDSPWetIDpqM7v3mu50IBgL983VeDa8eyFUXXmF-bGatL_yL8fOZfOT8AF_0BWRdUTXBsKuSThdxSs9K_bCRGLPEm5K8BvsoNgsBH3hsUjwNyzNhi7Cakn0HIWfXFCIbKc3KJe8R7yqfyiQaPVXPPPq0pJIM6Tc7Xw2mj2ux6C4EeOwSMvc637M8-bsyR8qSAbqeW93TJV46xD2uoTiVmY6zvOZylEecvyHOGrExwtj2jdqXNEJN5-8tGcmXk5ab4HRjseNYFl0RdVFFGBECj6brlLPsEPTaiAjiD8PGzovzmkfwCIp_DjZEbQCg1sVr0rIUPLdHAMdClTOgnfUEp06Spsie1yxx2Y6BtolRN8r8_wwmubd7wfgfhef7YbioKHJltU4COWLruFsZCzw2Ptg6RFotYJx-G3z9Y7mQFEJeTWmwtADGbaS9BEIbsbUZel8y_hED86Q3eTdz06pk8Z36Lgb-KgkcwMv3G1JGVltqy0w9UAvrbswrw4WlgtveMp9Zd0HovNic15pnrpgzvhmeroV84")
            .addHeader("lang", "en")
            .addHeader("Accept", "application/json")
            .build()

        return chain.proceed(newRequest)
    }
}