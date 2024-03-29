package org.m0skit0.android.inhaler.view

import android.content.res.Configuration
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.toast(@StringRes id: Int) {
    Toast.makeText(activity, id, Toast.LENGTH_LONG).show()
}

fun Fragment.toast(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
}

fun Fragment.isDarkModeOn(): Boolean =
    (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
