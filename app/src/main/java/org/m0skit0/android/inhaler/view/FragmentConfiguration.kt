package org.m0skit0.android.inhaler.view

import android.content.res.Configuration
import androidx.fragment.app.Fragment

fun Fragment.isDarkModeOn(): Boolean =
    (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
