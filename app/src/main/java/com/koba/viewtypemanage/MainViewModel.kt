package com.koba.viewtypemanage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _viewColorType = MutableLiveData<String>()
    val viewColorTypeLiveData: LiveData<String>
        get() = _viewColorType

    fun requestViewColorType(color: String){
        _viewColorType.value = color
    }
}