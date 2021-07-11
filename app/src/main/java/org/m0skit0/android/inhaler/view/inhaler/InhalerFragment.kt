package org.m0skit0.android.inhaler.view.inhaler

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.view.TitledFragment

@AndroidEntryPoint
class InhalerFragment : Fragment(), TitledFragment {
    override val titleId = R.string.inhaler
}
