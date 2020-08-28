package com.saurabh.dagger2withcoroutines.injection.module

import com.saurabh.dagger2withcoroutines.injection.scope.ActivityScope
import com.saurabh.dagger2withcoroutines.ui.home.HomeActivity
import com.saurabh.dagger2withcoroutines.ui.home.HomeActivityModule
import com.saurabh.dagger2withcoroutines.ui.joke.ShowJokeActivity
import com.saurabh.dagger2withcoroutines.ui.joke.ShowJokeActivityModule
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

/**
 * To create dependencies for a specific activity, don't extend the required activity module with #ActivityModule, instead create a plain module and include #BaseActivityModule in the annotation.
 */
@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector(
      modules = [ShowJokeActivityModule::class]
  )
  internal abstract fun bindShowJokeActivity(): ShowJokeActivity

  @ActivityScope
  @ContributesAndroidInjector(modules = [HomeActivityModule::class])
  internal abstract fun bindHomeActivity(): HomeActivity

}

@Module(includes = [BaseActivityModule::class])
abstract class ActivityModule<in T : DaggerAppCompatActivity> {
  @Binds
  @ActivityScope
  internal abstract fun bindActivity(activity: T): DaggerAppCompatActivity
}

/**
 * Activity specific common dependencies should be placed here
 */
@Module
open class BaseActivityModule {
  @ActivityScope
  @Provides internal fun provideRxPermissions(activity: DaggerAppCompatActivity) = RxPermissions(
      activity
  )
}