package org.journey.tridy_android.signup.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import org.journey.tridy_android.base.BaseFragment
import org.journey.tridy_android.databinding.FragmentSignupBinding

class SignupFragment : BaseFragment<FragmentSignupBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignupBinding {
        return FragmentSignupBinding.inflate(inflater,container,false )
    }
}