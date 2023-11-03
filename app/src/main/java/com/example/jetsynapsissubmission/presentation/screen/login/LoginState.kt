package com.example.jetsynapsissubmission.presentation.screen.login

import com.example.jetsynapsissubmission.domain.model.Login

data class LoginState(
    var isLoading: Boolean= false,
    var data: Login? = null,
    var error: String =  ""
)