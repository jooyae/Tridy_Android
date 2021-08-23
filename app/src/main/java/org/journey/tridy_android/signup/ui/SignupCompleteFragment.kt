package org.journey.tridy_android.signup.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.journey.tridy_android.R
import org.journey.tridy_android.databinding.FragmentSignupCompleteBinding
import org.journey.tridy_android.util.AutoClearedValue

class SignupCompleteFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentSignupCompleteBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupCompleteBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}