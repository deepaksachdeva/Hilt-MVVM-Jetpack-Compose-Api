package com.deepak.jetpack_compose_api.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.deepak.jetpack_compose_api.R
import com.deepak.jetpack_compose_api.data.model.NewsArticle
import com.deepak.jetpack_compose_api.ui.theme.JetpackComposeApiTheme
import com.deepak.jetpack_compose_api.ui.presentation.detail.DetailScreen
import com.deepak.jetpack_compose_api.ui.presentation.home.HomeScreen

private const val NEWS_ARG_KEY = "news"

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = Screen.valueOf(
        backStackEntry?.destination?.route ?: NavigationItem.Home.route
    )

    JetpackComposeApiTheme {
        Scaffold(
            topBar = {
                AddAppBar(
                    currentScreen = currentScreen,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            },
            content = { padding ->
                NavHost(
                    navController = navController,
                    startDestination = NavigationItem.Home.route,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    composable(route = NavigationItem.Home.route) {
                        HomeScreen {
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                NEWS_ARG_KEY,
                                it
                            )
                            navController.navigate(Screen.DETAILS.name)
                        }
                    }
                    composable(route = NavigationItem.Details.route) {
                        val newsArticle =
                            navController.previousBackStackEntry
                                ?.savedStateHandle
                                ?.get<NewsArticle>(NEWS_ARG_KEY)
                        newsArticle?.let {
                            DetailScreen(newsArticle) {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar(
    currentScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(stringResource(currentScreen.title))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}