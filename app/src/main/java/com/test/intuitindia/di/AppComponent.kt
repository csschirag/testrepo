package com.test.intuitindia.di

import com.test.intuitindia.AppApplication
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        SplashDIBuilder::class,
        CatListDIModel::class,
        CatListFragmentDIBuilder::class,
        MainActivityDIBuilder::class]
)
interface AppComponent {
    fun inject(application: AppApplication)
}