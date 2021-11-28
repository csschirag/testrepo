package com.test.intuitindia.network

import com.test.intuitindia.BuildConfig
import com.test.intuitindia.model.CatModel
import com.test.intuitindia.network.endpoint.CatListEndPoint
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import javax.inject.Inject

class CatListApiClient @Inject constructor() :
    BaseApiClient<CatListEndPoint>(BuildConfig.BASE_URL, CatListEndPoint::class.java),
    CatListApiClientInteractor {

    override fun getCatList(limit: Int, page: Int): Call<List<CatModel>> {
        return apiInterface.getCatList(limit, page)
    }

}