package org.journey.tridy_android.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("serImageURL")
    fun ImageView.setImageURL(url: String) { load(url) }
}