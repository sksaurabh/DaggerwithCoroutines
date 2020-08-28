package com.saurabh.dagger2withcoroutines.ui.joke

import android.content.Context
import com.saurabh.dagger2withcoroutines.injection.module.BaseActivityModule
import com.saurabh.dagger2withcoroutines.injection.qualifiers.ActivityContext
import com.saurabh.dagger2withcoroutines.injection.scope.ActivityScope
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
