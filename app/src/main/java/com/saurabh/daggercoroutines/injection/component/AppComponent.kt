package com.saurabh.daggercoroutines.injection.component

import android.content.Context
import com.saurabh.daggercoroutines.BaseApplication
import com.saurabh.daggercoroutines.injection.module.ActivityBindingModule
import com.saurabh.daggercoroutines.injection.module.AppModule
import com.saurabh.daggercoroutines.injection.module.NetworkModule
import com.saurabh.daggercoroutines.injection.module.PreferenceModule
import com.saurabh.daggercoroutines.injection.module.ViewModelFactoryModule
import com.saurabh.daggercoroutines.injection.qualifiers.ApplicationContext
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelFactoryModule::class, AndroidSupportInjectionModule::class, ActivityBindingModule::class, NetworkModule::class, PreferenceModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<BaseApplication>() {
    @BindsInstance
    abstract fun appContext(@ApplicationContext context: Context)

    override fun seedInstance(instance: BaseApplication?) {
      appContext(instance!!.applicationContext)
    }
  }
}
