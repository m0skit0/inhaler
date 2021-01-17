package org.m0skit0.android.inhaler.view

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import org.m0skit0.android.inhaler.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}