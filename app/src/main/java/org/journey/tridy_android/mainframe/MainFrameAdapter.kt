package org.journey.tridy_android.mainframe

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.journey.tridy_android.HomeFragment
import org.journey.tridy_android.jejulife.JejuLifeFragment
import org.journey.tridy_android.mypage.MyPageFragment
import org.journey.tridy_android.timeline.TimeLineFragment
import java.lang.RuntimeException

class MainFrameAdapter(fragment : Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount() = 4
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> JejuLifeFragment()
            2 -> TimeLineFragment()
            3 -> MyPageFragment()
            else -> throw RuntimeException("Fragment Load Error")
        }
    }
}