package com.test.intuitindia.network

import com.test.intuitindia.model.CatModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Call

interface CatListApiClientInteractor {
    fun getCatList(limit: Int, page: Int): Call<List<CatModel>>
}