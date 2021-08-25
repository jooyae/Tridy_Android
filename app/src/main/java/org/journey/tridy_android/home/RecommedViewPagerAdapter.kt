package org.journey.tridy_android.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class RecommedViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment {
        return RecommendCardFragment()
    }
}