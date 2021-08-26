package org.journey.tridy_android.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.journey.tridy_android.databinding.FragmentMyPageBinding
import org.journey.tridy_android.util.AutoClearedValue

class MyPageFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentMyPageBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}