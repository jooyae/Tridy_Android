package org.journey.tridy_android

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainFrameAdapter(fragment : Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }

}