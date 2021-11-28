package com.test.intuitindia.di

import com.test.intuitindia.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityDIBuilder {

    @ContributesAndroidInjector
    fun injectMainActivity(): MainActivity

}