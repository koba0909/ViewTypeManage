package com.koba.viewtypemanage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    enum class ColorType (val title: String, val colorCode: String){
        RED("RED", "#ff0000"),
        BLUE("BLUE", "#0011ff"),
        YELLOW("YELLOW", "#fffb00")
    }

    private var _viewColorType = MutableLiveData<String>()
    val viewColorTypeLiveData: LiveData<String>
        get() = _viewColorType

    fun requestViewColorType(type: ColorType){
        _viewColorType.value = type.colorCode
    }
}