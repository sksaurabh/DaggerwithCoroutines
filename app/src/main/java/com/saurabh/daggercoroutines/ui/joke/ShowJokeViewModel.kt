package com.saurabh.daggercoroutines.ui.joke

import androidx.lifecycle.MutableLiveData
import com.saurabh.daggercoroutines.data.model.Joke
import com.saurabh.daggercoroutines.ui.base.BaseViewModel
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