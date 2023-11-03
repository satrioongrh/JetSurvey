package com.example.jetsynapsissubmission.presentation.screen.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsynapsissubmission.domain.usecase.UseCase
import com.example.jetsynapsissubmission.utils.Resource
import com.example.jetsynapsissubmission.utils.SettingPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCase: UseCase,
    private val dataStore: SettingPref
) : ViewModel() {

    private val _login = mutableStateOf<LoginState>(LoginState())
    val login: State<LoginState> = _login

    fun doLogin(email: String, password: String) {
        _login.value = LoginState(isLoading = true)
        Log.d("0212", "doLogin: terpanggil")
        viewModelScope.launch(Dispatchers.IO) {
            val loginResult = useCase.login(email, password)
            Log.d("0212", "doLogi2n: $loginResult")
            when (loginResult) {
                is Resource.Success -> {
                    _login.value = LoginState(data = loginResult.data)
                    Log.d("02123", "doLogin: ${loginResult.data}")
                }

                is Resource.Error -> {
                    _login.value = LoginState(error = loginResult.error)
                }

                else -> {}
            }
        }
    }

    fun storeSessionLogin(value: Boolean) = runBlocking {
        dataStore.putBoolean(key = "session", value = value)
    }

    fun getSessionLogin(): Boolean? = runBlocking {
        dataStore.getBoolean("session")
    }

}