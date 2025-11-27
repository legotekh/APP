package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewScreenSizes

// УВАГА НА ІМПОРТИ НИЖЧЕ:
import com.example.myapp.presentation.screens.MainScreen
import com.example.myapp.presentation.screens.SettingsScreen
import com.example.myapp.presentation.screens.StreetsScreen
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                MyAppApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun MyAppApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.STREETS) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = { Icon(it.icon, contentDescription = it.label) },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val screenModifier = Modifier.padding(innerPadding)
            when (currentDestination) {
                AppDestinations.STREETS -> StreetsScreen(modifier = screenModifier)
                AppDestinations.MAIN -> MainScreen(modifier = screenModifier)
                AppDestinations.SETTINGS -> SettingsScreen(modifier = screenModifier)
            }
        }
    }
}

enum class AppDestinations(val label: String, val icon: ImageVector) {
    STREETS("Home", Icons.Default.Star),
    MAIN("Favorites", Icons.Default.MailOutline),
    SETTINGS("Profile", Icons.Default.Settings),
}