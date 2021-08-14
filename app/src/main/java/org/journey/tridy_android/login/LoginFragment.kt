package org.journey.tridy_android.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.journey.tridy_android.base.BaseFragment
import org.journey.tridy_android.databinding.FragmentLoginBinding

class LoginFragment: BaseFragment<FragmentLoginBinding>(){
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}