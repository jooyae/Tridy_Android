package org.journey.tridy_android.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load


object BindingAdapter {
    @JvmStatic
    @BindingAdapter("serImageURL")
    fun ImageView.setImageURL(url: String) { load(url) }
}