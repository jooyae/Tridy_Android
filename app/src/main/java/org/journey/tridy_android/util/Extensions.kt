package org.journey.tridy_android.util

import android.util.DisplayMetrics

object Extensions {
    fun Int.dpToPx(displayMetrics: DisplayMetrics): Int = (this * displayMetrics.density).toInt()

}