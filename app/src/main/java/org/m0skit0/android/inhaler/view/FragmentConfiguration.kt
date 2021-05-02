package org.m0skit0.android.inhaler.view

import android.content.res.Configuration

fun Configuration.isDarkModeOn(): Boolean =
    (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
