package com.koba.viewtypemanage

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class MainRepository {
    fun query(type: MainViewModel.ColorType): Single<item> {
        return Single.just(item(type.title, type.colorCode))
    }
}