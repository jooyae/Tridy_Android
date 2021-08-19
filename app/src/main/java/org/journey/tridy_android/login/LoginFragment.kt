package org.journey.tridy_android.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.KakaoSdkError
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint
import org.journey.tridy_android.base.BaseFragment
import org.journey.tridy_android.databinding.FragmentLoginBinding

@AndroidEntryPoint
class LoginFragment: BaseFragment<FragmentLoginBinding>(){
    private val viewModel by viewModels<LoginViewModel>()
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginKAKAO()
    }
    private fun loginKAKAO() {
        binding.buttonLoginKakao.setOnClickListener {
            checkKakaoToken()
        }
    }
    private fun checkKakaoToken() {
        AuthApiClient.instance.run {
            if (hasToken()) {
                UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                    if (error != null) {
                        if (error is KakaoSdkError && error.isInvalidTokenError()) {
                            //access토큰 갱신까지 실패한 것이기 때문에 refresh토큰이 유효하지 않음, 로그인 필요
                            getKakaoLogin()
                        }
                        else {
                            //기타 에러
                        }
                    }
                    else{
                        //토큰 유효성 체크 성공(필요 시 sdk내부에서 토큰 갱신됨)

                    }
                }
            }else {
                //단말에 토큰이 없으니 로그인 필요
                getKakaoLogin()
            }
        }
    }
    private fun getKakaoLogin() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                //Login Fail
            }
            else if (token != null) {
                //Login Success
                Log.e("access token", "${token.accessToken}")
                Log.e("access token expire", "${token.accessTokenExpiresAt}")
                Log.e("refresh token", "${token.refreshToken}")
                findNavController().popBackStack()
            }
        }

        UserApiClient.instance.run {
            if(isKakaoTalkLoginAvailable(requireContext())) {
                loginWithKakaoAccount(requireContext(), callback = callback)
            } else {
                loginWithKakaoAccount(requireContext(), callback = callback)
            }
        }
    }

}