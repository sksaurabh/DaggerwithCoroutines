package com.saurabh.dagger2withcoroutines.utils

import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import com.saurabh.dagger2withcoroutines.BuildConfig
import java.io.File

object FileUtils {
  fun getFileUri(file: File, context: Context): Uri {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID, file)
    } else {
      Uri.fromFile(file)
    }
  }
}
