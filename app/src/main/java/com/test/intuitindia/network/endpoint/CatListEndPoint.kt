package com.test.intuitindia.network.endpoint

import com.test.intuitindia.model.CatModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface CatListEndPoint {
    @GET("images/search?format=json&mime_types=png&order=ASC")
    fun getCatList(@Query("limit") limit: Int, @Query("page") page: Int): Call<List<CatModel>>
}