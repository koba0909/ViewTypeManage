package com.koba.viewtypemanage

import io.reactivex.Single

class MainRepository {
    fun query(type: MainViewModel.ColorType): Single<Item> {
        return Single.just(Item(type.title, type.colorCode))
    }
}