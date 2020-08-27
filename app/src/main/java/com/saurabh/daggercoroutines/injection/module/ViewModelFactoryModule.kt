package com.saurabh.daggercoroutines.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saurabh.daggercoroutines.injection.scope.ViewModelScope
import com.saurabh.daggercoroutines.ui.home.about.AboutViewModel
import com.saurabh.daggercoroutines.ui.home.HomeViewModel
import com.saurabh.daggercoroutines.ui.joke.ShowJokeViewModel
import com.saurabh.daggercoroutines.utils.ViewModelFactory
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
