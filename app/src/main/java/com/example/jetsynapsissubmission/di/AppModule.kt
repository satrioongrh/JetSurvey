package com.example.jetsynapsissubmission.di

import android.content.Context
import android.util.Log
import com.example.jetsynapsissubmission.data.RemoteDataRepository
import com.example.jetsynapsissubmission.data.network.api.ApiService
import com.example.jetsynapsissubmission.domain.repository.IRepository
import com.example.jetsynapsissubmission.domain.usecase.Interactor
import com.example.jetsynapsissubmission.domain.usecase.UseCase
import com.example.jetsynapsissubmission.utils.SettingPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val SETTING_PREFERENCES = "setting_preferences"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(): ApiService {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://panel-demo.obsight.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        Log.d("0212", "provideApiService: ApiService created")
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideLoginRepository(apiService: ApiService): IRepository {
        Log.d("0212", "provideLoginRepository: RemoteDataRepository created")
        return RemoteDataRepository(apiService)
    }

    @Provides
    fun provideLoginUseCase(loginRepository: IRepository): UseCase {
        Log.d("0212", "provideLoginUseCase: UseCase created")
        return Interactor(loginRepository)
    }


    @Provides
    fun providePreferencesDataStore(@ApplicationContext appContext: Context): SettingPref = SettingPref(appContext)
}