package org.m0skit0.android.inhaler.view.punch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.m0skit0.android.inhaler.R

@AndroidEntryPoint
class PunchFragment : Fragment() {

    private val viewModel: PunchFragmentViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_punch, container, false).apply {
                initializeViews()
            }

    private fun View.initializeViews() {
        findViewById<Button>(R.id.punch).setOnClickListener {
            viewModel.onPunchClicked()
        }
    }
}
