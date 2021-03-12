package org.m0skit0.android.inhaler.view.punch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.m0skit0.android.inhaler.R
import org.m0skit0.android.inhaler.view.TitledFragment
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class PunchFragment : Fragment(), TitledFragment {

    companion object {
        private val DISABLED_INTERVAL = TimeUnit.SECONDS.toMillis(10)
    }

    override val titleId = R.string.punch

    private val viewModel: PunchViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_punch, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.initializeViews()
    }

    private fun View.initializeViews() {
        findViewById<Button>(R.id.punch).setOnClickListener { punchButton ->
            viewModel.onPunchClicked()
            toastSuccess()
            punchButton.disableForAWhile()
        }
    }

    private fun toastSuccess() {
        Toast.makeText(activity, R.string.punch_success, Toast.LENGTH_LONG).show()
    }

    private fun View.disableForAWhile() {
        isEnabled = false
        alpha = .25f
        lifecycleScope.launch {
            delay(DISABLED_INTERVAL)
            isEnabled = true
            alpha = 1f
        }
    }
}
