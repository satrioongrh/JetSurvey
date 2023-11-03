package com.example.jetsynapsissubmission.data.network.api

import com.example.jetsynapsissubmission.data.network.response.LoginResponse
import com.example.jetsynapsissubmission.data.network.response.SurveyResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<LoginResponse>

    @GET("survey")
    @FormUrlEncoded
    fun getAllSurvey() : Call<SurveyResponse>

}