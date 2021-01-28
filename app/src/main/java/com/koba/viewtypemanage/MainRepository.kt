package com.koba.viewtypemanage

import com.koba.viewtypemanage.data.ColorType
import com.koba.viewtypemanage.data.Item
import io.reactivex.Single

class MainRepository {
    fun query(type: ColorType): Single<Item> {
        return Single.just(
            Item(
                type.title,
                type.colorCode
            )
        )
    }
}