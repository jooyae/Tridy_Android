package org.journey.tridy_android.application

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp
import org.journey.tridy_android.BuildConfig
import org.journey.tridy_android.R

@HiltAndroidApp
class TridyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, getString(R.string.kakao_app_key))
    }
}