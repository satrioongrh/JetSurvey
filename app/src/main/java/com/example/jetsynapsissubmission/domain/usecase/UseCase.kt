package com.example.jetsynapsissubmission.domain.usecase

import com.example.jetsynapsissubmission.domain.model.Login
import com.example.jetsynapsissubmission.utils.Resource

interface UseCase {

    suspend fun login(email: String, password: String) : Resource<Login>

}