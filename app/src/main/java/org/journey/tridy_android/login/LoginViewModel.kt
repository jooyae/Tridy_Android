package org.journey.tridy_android.login

import android.text.BoringLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import org.journey.tridy_android.base.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : DisposableViewModel() {
    private val _accessToken = MutableLiveData<String>()
    private val _kakaoLogin = MutableLiveData<Boolean>()
    private val _googleLogin = MutableLiveData<Boolean>()

    val kakaoLogin: LiveData<Boolean>
        get() = _kakaoLogin

    val googleLogin : LiveData<Boolean>
        get() = _googleLogin

    val accessToken: LiveData<String>
        get() = _accessToken

    private val _refreshToken = MutableLiveData<String>()
    val refreshToken: LiveData<String>
        get() = _refreshToken

    private val _loginSuccess = MutableLiveData<String>()
    val loginSuccess: LiveData<String>
        get() = _loginSuccess

    companion object {
        private const val GOOGLE_CLIENT_ID = "693005602584-jrorcutifa6v5ptp5l0a2ngd82gmaerv.apps.googleusercontent.com"
    }
}