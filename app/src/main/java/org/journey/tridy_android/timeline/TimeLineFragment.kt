package org.journey.tridy_android.timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.journey.tridy_android.databinding.FragmentTimeLineBinding
import org.journey.tridy_android.util.AutoClearedValue

class TimeLineFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentTimeLineBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimeLineBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}