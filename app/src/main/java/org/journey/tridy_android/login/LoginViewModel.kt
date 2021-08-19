package org.journey.tridy_android.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.journey.tridy_android.base.DisposableViewModel
import org.journey.tridy_android.util.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
): DisposableViewModel(){
    private val _accessToken = MutableLiveData<String>()
    //private val _kakaoLogin = SingleLiveEvent<Session>()

    val accessToken : LiveData<String>
        get() = _accessToken

    private val _refreshToken = MutableLiveData<String>()
    val refreshToken: LiveData<String>
        get() = _refreshToken

    private val _loginSuccess = MutableLiveData<String>()
    val loginSuccess : LiveData<String>
        get() = _loginSuccess

}