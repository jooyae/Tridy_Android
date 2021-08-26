package org.journey.tridy_android.mainframe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import org.journey.tridy_android.HomeFragment
import org.journey.tridy_android.R
import org.journey.tridy_android.databinding.FragmentMainFrameBinding
import org.journey.tridy_android.jejulife.JejuLifeFragment
import org.journey.tridy_android.mypage.MyPageFragment
import org.journey.tridy_android.timeline.TimeLineFragment
import org.journey.tridy_android.util.AutoClearedValue

@AndroidEntryPoint
class MainFrameFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentMainFrameBinding>()
    private val viewModel : MainFrameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainFrameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        initViewPager()
        configureBottomNaviagtion()
    }

    private fun observeViewModel(){
        viewModel.pageIndex.observe(viewLifecycleOwner){ pageIndex ->
            binding.viewpagerMainFrame.currentItem = pageIndex
            selectBottomNavigationMenu(pageIndex)
        }
    }
    private fun selectBottomNavigationMenu(pageIndex: Int) {
        binding.bottomNavigation.selectedItemId = when (pageIndex) {
            0 -> R.id.homeFragment
            1 -> R.id.jejuLifeFragment
            2 -> R.id.timeLineFragment
            3 -> R.id.myPageFragment
            else -> throw RuntimeException("Bottom Navigation Load Error")
        }
    }
    private fun initViewPager() = binding.viewpagerMainFrame.run{
        offscreenPageLimit = 3
        adapter = MainFrameAdapter(this@MainFrameFragment)
        registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.changePageIdx(position)
            }
        })
    }
    private fun configureBottomNaviagtion() = binding.bottomNavigation.run {
        setOnItemSelectedListener { item->
            viewModel.changePageIdx(
                when(item.itemId){
                    R.id.homeFragment -> 0
                    R.id.jejuLifeFragment -> 1
                    R.id.timeLineFragment -> 2
                    R.id.myPageFragment -> 3
                    else -> throw java.lang.RuntimeException("Bottom Navigation Item Error")
                }
            )
            true
        }
    }

}