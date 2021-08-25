package org.journey.tridy_android.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.journey.tridy_android.databinding.FragmentRecommendCardBinding
import org.journey.tridy_android.util.AutoClearedValue

class RecommendCardFragment: Fragment() {
    private var binding by AutoClearedValue<FragmentRecommendCardBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}