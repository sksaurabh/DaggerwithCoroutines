package com.saurabh.dagger2withcoroutines.injection.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.saurabh.dagger2withcoroutines.injection.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferenceModule {

  @Provides @Singleton
  internal fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(context)
  }

}
