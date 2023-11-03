package com.example.jetsynapsissubmission.utils

import com.example.jetsynapsissubmission.data.network.response.DataResponse
import com.example.jetsynapsissubmission.data.network.response.LoginResponse
import com.example.jetsynapsissubmission.domain.model.Data
import com.example.jetsynapsissubmission.domain.model.Login

fun LoginResponse.toDomain(): Login {
    return Login(
            code ?: 0,
            data?.toDomain() ?: Data("", 0),
            message ?: "",
            status ?: false,
            )
}

fun DataResponse.toDomain(): Data {
    return Data(
        occupationName ?: "",
        occupationLevel ?: 0
    )
}