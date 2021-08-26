package org.journey.tridy_android.jejulife

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.journey.tridy_android.databinding.FragmentJejuLifeBinding

import org.journey.tridy_android.util.AutoClearedValue

class JejuLifeFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentJejuLifeBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJejuLifeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}