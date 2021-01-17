package org.m0skit0.android.inhaler.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import org.m0skit0.android.inhaler.R

class PunchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_punch, container, false).apply {
                findViewById<Button>(R.id.punch).setOnClickListener {
                    println("Hello")
                }
            }
}