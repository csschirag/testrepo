package com.test.intuitindia

import android.app.Application
import com.test.intuitindia.di.AppComponent
import com.test.intuitindia.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AppApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        val applicationComponent = DaggerAppComponent.create()
        applicationComponent.inject(this)
        super.onCreate()
    }

}