package com.example.formulariop3

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform