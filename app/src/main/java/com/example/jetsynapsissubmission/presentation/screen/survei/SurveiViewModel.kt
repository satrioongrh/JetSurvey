package com.example.jetsynapsissubmission.presentation.screen.survei

import androidx.lifecycle.ViewModel
import com.example.jetsynapsissubmission.utils.SettingPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SurveiViewModel @Inject constructor(
    private val dataStore: SettingPref
) : ViewModel() {

    fun clearPref() = runBlocking {
        dataStore.clearPref(key = "session")
    }

}