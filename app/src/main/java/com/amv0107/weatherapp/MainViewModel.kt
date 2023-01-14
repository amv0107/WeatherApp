package com.amv0107.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amv0107.weatherapp.adapters.WeatherModel

class MainViewModel : ViewModel(){

    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}