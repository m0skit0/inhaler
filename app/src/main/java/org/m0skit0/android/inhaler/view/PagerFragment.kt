package org.m0skit0.android.inhaler.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.view.history.PunchHistoryFragment
import org.m0skit0.android.inhaler.view.punch.PunchFragment
import org.m0skit0.android.inhaler.view.stats.PunchStatisticsFragment

@AndroidEntryPoint
class PagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_viewpager, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with (view) {
            val pager = findViewById<ViewPager>(R.id.pager).apply {
                adapter = PagerFragmentAdapter(childFragmentManager)
            }
            findViewById<TabLayout>(R.id.tabs).setupWithViewPager(pager)
        }
    }

    class PagerFragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val fragments: Array<Fragment> = arrayOf(
            PunchFragment(),
            PunchStatisticsFragment(),
            PunchHistoryFragment(),
        )

        override fun getCount(): Int = fragments.size

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getPageTitle(position: Int): CharSequence = (fragments[position] as TitledFragment).title
    }
}
