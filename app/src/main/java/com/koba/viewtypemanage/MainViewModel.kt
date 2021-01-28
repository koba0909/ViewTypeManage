package com.koba.viewtypemanage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.koba.viewtypemanage.data.ColorType
import com.koba.viewtypemanage.data.MainResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MainViewModel: ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val mainRepository = MainRepository()

    private val _stateLiveData = MutableLiveData<MainResult>()
    val stateLiveData: LiveData<MainResult>
        get() = _stateLiveData

    fun requestViewColorType(type: ColorType){
        mainRepository.query(type)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _stateLiveData.value = MainResult.InProgress
            }
            .subscribe ({
                _stateLiveData.value = MainResult.Success(it)
            },{
                _stateLiveData.value = MainResult.Error(it)
            }).add()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun Disposable.add() = apply { compositeDisposable.add(this) }
}