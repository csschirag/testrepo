package com.test.intuitindia.repo

import com.test.intuitindia.model.CatModel
import com.test.intuitindia.network.CatListApiClientInteractor
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CatListService @Inject constructor() {

    /**
     * we may mock this catlistapi with test api client as well for unit testing
     */
    @Inject
    lateinit var catListApi: CatListApiClientInteractor

    fun getCatList(limit: Int, page: Int): Single<List<CatModel>> {
        return Single.fromCallable {  catListApi.getCatList(limit, page).execute().body()}
    }

}