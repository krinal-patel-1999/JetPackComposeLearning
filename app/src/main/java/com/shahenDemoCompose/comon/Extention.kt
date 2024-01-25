package com.shahenDemoCompose.comon

import android.util.Patterns
import com.shahenDemoCompose.util.Contsants.PASSWORD_MAX_LENGTH
import com.shahenDemoCompose.util.Contsants.PASSWORD_MIN_LENGTH

fun String.isEmailValid(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isPasswordValid(): Boolean {
    return if (this.length < PASSWORD_MIN_LENGTH) {
        false
    } else this.length <= PASSWORD_MAX_LENGTH
}