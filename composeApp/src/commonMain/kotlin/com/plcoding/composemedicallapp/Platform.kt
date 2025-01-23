package com.plcoding.composemedicallapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform