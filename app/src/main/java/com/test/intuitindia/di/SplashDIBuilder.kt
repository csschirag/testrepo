package com.test.intuitindia.di

import com.test.intuitindia.ui.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SplashDIBuilder {
    @ContributesAndroidInjector
    fun injectSplashActivity(): SplashActivity
}