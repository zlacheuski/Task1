package com.example.task1.ui.weatheralert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.data.mapper.WeatherAlertMapper
import com.example.task1.data.model.weatheralert.WeatherAlertRemote
import com.example.task1.data.repository.Resource
import com.example.task1.data.repository.weatheralert.WeatherAlertRepositoryImpl
import com.example.task1.ui.weatheralert.model.WeatherAlertListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherAlertViewModel @Inject constructor(private val weatherAlertRepository: WeatherAlertRepositoryImpl) :
    ViewModel() {

    private val _response =
        MutableStateFlow<Resource<WeatherAlertRemote>>(Resource.Progress())
    val response: StateFlow<Resource<WeatherAlertRemote>>
        get() = _response

    init {
        getWeatherAlerts()
    }

    private fun getWeatherAlerts() {
        viewModelScope.launch(Dispatchers.IO) {
            weatherAlertRepository.getWeatherAlertsList().collect {
                _response.emit(it)
            }
        }
    }

    fun getMappedAlertsList(weatherAlert: WeatherAlertRemote): WeatherAlertListModel {
        return WeatherAlertMapper.mapWeatherAlertToModel(weatherAlert)
    }
}