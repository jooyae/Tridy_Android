package org.journey.tridy_android.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.journey.tridy_android.R
import org.journey.tridy_android.base.BaseFragment
import org.journey.tridy_android.databinding.FragmentSplashBinding
import java.util.concurrent.TimeUnit

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startSplash()
    }

    @SuppressLint("CheckResult")
    private fun startSplash(){
        Observable.timer(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("Entry","start splash")
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_splashFragment_to_loginFragment)
            }, {
                it.printStackTrace()
            })
    }
}