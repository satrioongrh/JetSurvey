package com.example.jetsynapsissubmission.domain.repository

import com.example.jetsynapsissubmission.domain.model.Login
import com.example.jetsynapsissubmission.utils.Resource

interface IRepository {

    suspend fun login(email: String, password: String): Resource<Login>

}