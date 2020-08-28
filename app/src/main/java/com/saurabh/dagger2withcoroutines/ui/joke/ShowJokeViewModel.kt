package com.saurabh.dagger2withcoroutines.ui.joke

import androidx.lifecycle.MutableLiveData
import com.saurabh.dagger2withcoroutines.data.model.Joke
import com.saurabh.dagger2withcoroutines.ui.base.BaseViewModel
import javax.inject.Inject

class ShowJokeViewModel @Inject constructor() : BaseViewModel() {

  val jokeStringLiveData = MutableLiveData<String>()

  fun showJoke(jokeList: ArrayList<Joke>) {
    var jokeString = ""
    for (joke in jokeList) {
      jokeString = jokeString + joke.joke.replace("&quot;", "\"") + "\n\n"
    }

    jokeStringLiveData.postValue(jokeString)
  }

}