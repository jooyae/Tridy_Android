package org.journey.tridy_android.login

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.KakaoSdkError
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint
import org.journey.tridy_android.R
import org.journey.tridy_android.base.BaseFragment
import org.journey.tridy_android.databinding.FragmentLoginBinding
import org.journey.tridy_android.util.DiffCallback

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var navController: NavController
    private var callbackManager: DiffUtil? = null
    private val viewModel by viewModels<LoginViewModel>()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        launchWithKAKAO()
        launchWithGoogle()
    }

    private fun launchWithKAKAO() {
        binding.buttonLoginKakao.setOnClickListener {
            checkKakaoToken()
        }

    }

    private fun launchWithGoogle() {
        checkGoogleGso()
    }

    private fun checkGoogleGso(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.firebase_app_key))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(context,gso)
        binding.buttonLoginGoogle.setOnClickListener {
                signGoogle()
        }
    }
    private fun signGoogle(){
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, GOOGLE_REQUEST_CODE)
    }


    private fun checkKakaoToken() {
        AuthApiClient.instance.run {
            if (hasToken()) {
                UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                    if (error != null) {
                        if (error is KakaoSdkError && error.isInvalidTokenError()) {
                            //access토큰 갱신까지 실패한 것이기 때문에 refresh토큰이 유효하지 않음, 로그인 필요
                            getKakaoLogin()
                        } else {
                            //기타 에러
                        }
                    } else {
                        //토큰 유효성 체크 성공(필요 시 sdk내부에서 토큰 갱신됨)
                    }
                }
            } else {
                //단말에 토큰이 없으니 로그인 필요
                getKakaoLogin()
            }
        }
    }

    private fun getKakaoLogin() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                //Login Fail
            } else if (token != null) {
                //Login Success
                Log.e("access token", "${token.accessToken}")
                Log.e("access token expire", "${token.accessTokenExpiresAt}")
                Log.e("refresh token", "${token.refreshToken}")
                findNavController().popBackStack()
            }
        }

        UserApiClient.instance.run {
            if (isKakaoTalkLoginAvailable(requireContext())) {
                loginWithKakaoAccount(requireContext(), callback = callback)
            } else {
                loginWithKakaoAccount(requireContext(), callback = callback)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //callbackManager?.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GOOGLE_REQUEST_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(ContentValues.TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(ContentValues.TAG, "Google sign in failed", e)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth?.signInWithCredential(credential)
//            ?.addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(ContentValues.TAG, "로그인 성공")
//                    val user = auth!!.currentUser
//
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(ContentValues.TAG, "signInWithCredential:failure", task.exception)
//                }
//            }
    }

    companion object {
        private const val GOOGLE_REQUEST_CODE = 99
    }


}

