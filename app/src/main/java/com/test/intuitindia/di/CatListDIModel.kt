package com.test.intuitindia.di

import com.test.intuitindia.network.CatListApiClient
import com.test.intuitindia.network.CatListApiClientInteractor
import dagger.Module
import dagger.Provides

@Module
class CatListDIModel {

    @Provides
    fun provideCatListApiModel(catListApiClient: CatListApiClient): CatListApiClientInteractor {
        return catListApiClient
    }

}