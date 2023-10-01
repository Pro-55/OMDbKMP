package com.example.omdb_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform