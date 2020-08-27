package com.saurabh.daggercoroutines.ui.joke

import android.content.Context
import com.saurabh.daggercoroutines.injection.module.BaseActivityModule
import com.saurabh.daggercoroutines.injection.qualifiers.ActivityContext
import com.saurabh.daggercoroutines.injection.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity

@Module(includes = [BaseActivityModule::class])
abstract class ShowJokeActivityModule {

  @Binds
  @ActivityContext abstract fun provideActivityContext(activity: ShowJokeActivity): Context

  @Binds
  @ActivityScope
  abstract fun provideActivity(showJokeActivity: ShowJokeActivity): DaggerAppCompatActivity
}
