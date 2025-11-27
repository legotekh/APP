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
fun StreetsScreen(modifier: Modifier = Modifier) {
    val nestedNavController = rememberNavController()
    NavHost(
        navController = nestedNavController,
        startDestination = "streets_sub_a",
        modifier = modifier
    ) {
        composable("streets_sub_a") {
            StreetsSubScreenA(onNavigateToB = { nestedNavController.navigate("streets_sub_b") })
        }
        composable("streets_sub_b") {
            StreetsSubScreenB(onNavigateBack = { nestedNavController.popBackStack() })
        }
    }
}

@Composable
fun StreetsSubScreenA(modifier: Modifier = Modifier, onNavigateToB: () -> Unit) {
    var labelText by rememberSaveable { mutableStateOf("Це Підекран А") }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = labelText)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { labelText = "Натиснуто!"; onNavigateToB() }) {
            Text("Перейти далі")
        }
    }
}

@Composable
fun StreetsSubScreenB(modifier: Modifier = Modifier, onNavigateBack: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Це Підекран Б", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onNavigateBack) { Text("Назад") }
    }
}