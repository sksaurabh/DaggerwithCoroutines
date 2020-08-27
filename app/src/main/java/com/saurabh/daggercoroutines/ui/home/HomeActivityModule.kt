package com.saurabh.daggercoroutines.ui.home

import android.content.Context
import com.saurabh.daggercoroutines.injection.module.BaseActivityModule
import com.saurabh.daggercoroutines.injection.qualifiers.ActivityContext
import com.saurabh.daggercoroutines.injection.scope.ActivityScope
import com.saurabh.daggercoroutines.injection.scope.FragmentScoped
import com.saurabh.daggercoroutines.ui.home.about.AboutFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

@Module(includes = [BaseActivityModule::class])
abstract class HomeActivityModule {

  @FragmentScoped
  @ContributesAndroidInjector
  internal abstract fun showAboutFragment(): AboutFragment

  @Binds
  @ActivityContext abstract fun provideActivityContext(activity: HomeActivity): Context

  @Binds
  @ActivityScope
  abstract fun provideActivity(homeActivity: HomeActivity): DaggerAppCompatActivity
}