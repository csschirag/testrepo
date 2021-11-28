package com.test.intuitindia.di

import com.test.intuitindia.ui.CatListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CatListFragmentDIBuilder {

    @ContributesAndroidInjector
    fun injectCatListFragment(): CatListFragment

}