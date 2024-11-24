package com.example.tastetributes.utils

import com.example.tastetributes.utils.Constants.EMAIL_REGEX

fun String.isEmailValid(): Boolean {
    val pattern = Regex(EMAIL_REGEX)
    return pattern.matches(this)
}

fun String.isPasswordValid(): Boolean {
    return !(this.length < 8 || this.length > 15)
}

fun String.isConfirmPasswordValid(password: String): Boolean {
    return !(password == this).not()

}