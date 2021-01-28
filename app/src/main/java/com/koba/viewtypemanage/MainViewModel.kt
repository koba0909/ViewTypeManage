package com.koba.viewtypemanage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    enum class ColorType {
        RED, BLUE, YELLOW
    }

    private var _viewColorType = MutableLiveData<String>()
    val viewColorTypeLiveData: LiveData<String>
        get() = _viewColorType

    fun requestViewColorType(type: ColorType){
        _viewColorType.value = when(type){
            ColorType.RED -> "#ff0000"
            ColorType.BLUE -> "#0011ff"
            ColorType.YELLOW -> "#fffb00"
        }
    }
}