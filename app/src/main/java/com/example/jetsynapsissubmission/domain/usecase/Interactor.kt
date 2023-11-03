package com.example.jetsynapsissubmission.domain.usecase

import android.util.Log
import com.example.jetsynapsissubmission.domain.model.Login
import com.example.jetsynapsissubmission.domain.model.Survey
import com.example.jetsynapsissubmission.domain.repository.IRepository
import com.example.jetsynapsissubmission.utils.Resource
import javax.inject.Inject

class Interactor @Inject constructor(private val remoteDataRepository: IRepository) : UseCase {
    override suspend fun login(email: String, password: String): Resource<Login> {
        Log.d("0212", "login: terpanggil")
        return remoteDataRepository.login(email, password)
    }

}