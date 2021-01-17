package org.m0skit0.android.inhaler.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.view.punch.PunchFragment

class PagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_viewpager, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<ViewPager>(R.id.pager).apply {
            adapter = PagerFragmentAdapter(childFragmentManager)
        }
    }

    class PagerFragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val fragments = arrayOf(
            PunchFragment()
        )

        override fun getCount(): Int = fragments.size

        override fun getItem(position: Int): Fragment = fragments[position]
    }
}
