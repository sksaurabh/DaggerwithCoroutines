package com.saurabh.dagger2withcoroutines.injection.component

import android.content.Context
import com.saurabh.dagger2withcoroutines.BaseApplication
import com.saurabh.dagger2withcoroutines.injection.module.ActivityBindingModule
import com.saurabh.dagger2withcoroutines.injection.module.AppModule
import com.saurabh.dagger2withcoroutines.injection.module.NetworkModule
import com.saurabh.dagger2withcoroutines.injection.module.PreferenceModule
import com.saurabh.dagger2withcoroutines.injection.module.ViewModelFactoryModule
import com.saurabh.dagger2withcoroutines.injection.qualifiers.ApplicationContext
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
