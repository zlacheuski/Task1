package com.example.task1.ui.weatheralert

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.data.repository.weatheralert.WeatherAlertRepositoryImpl
import com.example.task1.domain.model.WeatherAlertModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WeatherAlertViewModel @Inject constructor(
    private val weatherAlertRepository: WeatherAlertRepositoryImpl,
) : ViewModel() {

    private val _weatherAlertList =
        MutableStateFlow<List<WeatherAlertModel>>(emptyList())
    val weatherAlertList: Flow<List<WeatherAlertModel>>
        get() = _weatherAlertList

    private val _isProgressVisible =
        MutableStateFlow(false)
    val isProgressVisible: Flow<Boolean>
        get() = _isProgressVisible

    init {
        getWeatherAlerts()
    }

    private fun getWeatherAlerts() {
        viewModelScope.launch(exceptionHandler) {
            withContext(Dispatchers.IO) {
                _isProgressVisible.emit(true)
                val weatherAlertList = weatherAlertRepository.getWeatherAlertsList()
                _weatherAlertList.emit(weatherAlertList)
            }
        }.invokeOnCompletion {
            viewModelScope.launch {
                _isProgressVisible.emit(false)
            }
        }
    }

    private val exceptionHandler
        get() = CoroutineExceptionHandler { _, e ->
            viewModelScope.launch {
                _isProgressVisible.emit(false)
                Log.d("Exception", e.localizedMessage ?: e.toString())
            }
        }
}