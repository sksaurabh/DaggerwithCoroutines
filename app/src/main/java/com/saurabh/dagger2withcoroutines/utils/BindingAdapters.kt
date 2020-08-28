package com.saurabh.dagger2withcoroutines.utils

import androidx.databinding.BindingAdapter
import android.view.View

object BindingAdapters {

  @BindingAdapter("visibility") fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
  }
}
