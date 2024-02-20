package com.deepak.jetpack_compose_api.navigation

import com.deepak.jetpack_compose_api.R

enum class Screen(val title: Int) {
    HOME(R.string.home),
    DETAILS(R.string.detail)
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object Details : NavigationItem(Screen.DETAILS.name)
}