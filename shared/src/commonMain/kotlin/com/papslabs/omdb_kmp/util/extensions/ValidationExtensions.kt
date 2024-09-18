package com.papslabs.omdb_kmp.util.extensions

fun String?.isValidEmail(): Boolean {
    val email = this?.trim() ?: return false
    val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
    return emailRegex.matches(email)
}