package com.example.jetsynapsissubmission.data

import android.util.Log
import com.example.jetsynapsissubmission.data.network.api.ApiService
import com.example.jetsynapsissubmission.domain.model.Login
import com.example.jetsynapsissubmission.domain.repository.IRepository
import com.example.jetsynapsissubmission.utils.Resource
import com.example.jetsynapsissubmission.utils.toDomain
import javax.inject.Inject

class RemoteDataRepository @Inject constructor(private val apiService: ApiService) : IRepository {

    override suspend fun login(email: String, password: String): Resource<Login> {
        try {
            Log.d("0212", "loginr: terpanggil")
            val response = apiService.login(email, password).execute()
            Log.d("0212", "login2: $response")
            if (response.body()!!.code == 200) {
                return Resource.Success(response.body()!!.toDomain())
            } else {
                return Resource.Error(response.body()!!.toDomain().message!!)
            }
        } catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

//    override suspend fun getAllSurvey(): Resource<Survey> {
//        try {
//            val response = apiService.getAllSurvey().execute()
//            if (response.body().code == 200){
//                return Resource.Success(response.body())
//            }
//        }
//    }

}