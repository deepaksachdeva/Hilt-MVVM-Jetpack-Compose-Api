package com.deepak.jetpack_compose_api.utils

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

object Util {

    fun newsInDetail(context: Context, url: String) {
        val packageName = "com.android.chrome"
        val customBuilder = CustomTabsIntent.Builder()
            .setShowTitle(true)
            .setInstantAppsEnabled(true)
            .build()
        customBuilder.intent.setPackage(packageName)
        customBuilder.launchUrl(context, Uri.parse(url))
    }
}
