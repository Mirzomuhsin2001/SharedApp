package com.example.sharedapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform