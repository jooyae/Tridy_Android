package org.journey.tridy_android

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load


object BindingAdapter {
    @JvmStatic
    @BindingAdapter
    fun ImageView.setImageURL(url: String) { load(url) }
}