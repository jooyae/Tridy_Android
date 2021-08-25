package org.journey.tridy_android.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.MarginPageTransformer
import org.journey.tridy_android.R
import org.journey.tridy_android.databinding.FragmentHomeBinding
import org.journey.tridy_android.util.AutoClearedValue
import org.journey.tridy_android.util.Extensions.dpToPx

class HomeFragment: Fragment() {
    private var binding by AutoClearedValue<FragmentHomeBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMainCardViewPager()
    }

    private fun setMainCardViewPager() {
        // 좌/우 노출되는 크기를 크게하려면 offsetPx 증가
        val offsetPx = 15.dpToPx(resources.displayMetrics)
        // 페이지간 마진 크게하려면 pageMarginPx 증가
        val pageMarginPx = 10.dpToPx(resources.displayMetrics)

        binding.viewpagerRandomRecommendation.apply {
            offscreenPageLimit = 4
            adapter = RecommedViewPagerAdapter(this@HomeFragment)
            setPadding(offsetPx, 0, offsetPx, 0)
            val marginTransformer = MarginPageTransformer(pageMarginPx)
            setPageTransformer(marginTransformer)
        }
    }
}