package com.example.jetsynapsissubmission.domain.model


data class Login (
    val code: Int? = null,
    val data: Data? = null,
    val message: String? = null,
    val status: Boolean? = null
)

data class Data (
    val occupationName: String? = null,
    val occupationLevel: Int? = null
)