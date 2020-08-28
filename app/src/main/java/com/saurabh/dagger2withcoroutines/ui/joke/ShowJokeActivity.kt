package com.saurabh.dagger2withcoroutines.ui.joke

import android.os.Bundle
import com.saurabh.dagger2withcoroutines.R
import com.saurabh.dagger2withcoroutines.data.model.Joke
import com.saurabh.dagger2withcoroutines.databinding.ActivityShowjokeBinding
import com.saurabh.dagger2withcoroutines.ui.base.ActivityNavigator
import com.saurabh.dagger2withcoroutines.ui.base.BaseActivity

class ShowJokeActivity : BaseActivity<ActivityShowjokeBinding, ShowJokeViewModel>() {

  companion object {
    const val JOKE_LIST_INTENT = "Joke_list_intent"
  }

  override fun getViewModelClass(): Class<ShowJokeViewModel> = ShowJokeViewModel::class.java

  override fun layoutId(): Int {
    return R.layout.activity_showjoke
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val jokeList = intent.getParcelableArrayListExtra<Joke>(JOKE_LIST_INTENT)
    binding.lifecycleOwner = this
    viewModel.showJoke(jokeList)
    initToolbar()
  }

  private fun initToolbar() {
    setSupportActionBar(binding.toolbar)
    supportActionBar?.setHomeButtonEnabled(true)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    binding.toolbar.setNavigationOnClickListener { onBackPressed() }
  }

  override fun onBackPressed() {
    ActivityNavigator.finishActivityWithAnimation(R.anim.slide_right_in, R.anim.slide_right_out, this)
  }

}
