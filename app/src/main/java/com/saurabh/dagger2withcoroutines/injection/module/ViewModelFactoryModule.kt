package com.saurabh.dagger2withcoroutines.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saurabh.dagger2withcoroutines.injection.scope.ViewModelScope
import com.saurabh.dagger2withcoroutines.ui.home.about.AboutViewModel
import com.saurabh.dagger2withcoroutines.ui.home.HomeViewModel
import com.saurabh.dagger2withcoroutines.ui.joke.ShowJokeViewModel
import com.saurabh.dagger2withcoroutines.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

  @Binds
  @IntoMap
  @ViewModelScope(ShowJokeViewModel::class)
  abstract fun bindShowJokeViewModel(showJokeViewModel: ShowJokeViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelScope(HomeViewModel::class)
  abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

  @Binds
  internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelScope(AboutViewModel::class)
  abstract fun bindAboutViewModel(aboutViewModel: AboutViewModel): ViewModel

}
