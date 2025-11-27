package com.example.myapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val nestedNavController = rememberNavController()
    NavHost(
        navController = nestedNavController,
        startDestination = "home_sub_a", // змінив назву роута
        modifier = modifier
    ) {
        composable("home_sub_a") {
            HomeSubScreenA(onNavigateToB = { nestedNavController.navigate("home_sub_b") })
        }
        composable("home_sub_b") {
            HomeSubScreenB(onNavigateBack = { nestedNavController.popBackStack() })
        }
    }
}

@Composable
fun HomeSubScreenA(modifier: Modifier = Modifier, onNavigateToB: () -> Unit) {
    var labelText by rememberSaveable { mutableStateOf("Це екран Home (А)") }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = labelText)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { labelText = "Натиснуто!"; onNavigateToB() }) {
            Text("Детальніше")
        }
    }
}

@Composable
fun HomeSubScreenB(modifier: Modifier = Modifier, onNavigateBack: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Це екран Home (Б)", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onNavigateBack) { Text("Назад") }
    }
}