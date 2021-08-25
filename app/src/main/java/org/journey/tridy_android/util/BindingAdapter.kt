package org.journey.tridy_android.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("setImageURL")
    fun ImageView.setImageURL(url: String) { load(url) }

    @JvmStatic
    @BindingAdapter("corner_radius")
    fun ShapeableImageView.setCornerRadius(radius: Float) {
        shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(radius)
    }
}