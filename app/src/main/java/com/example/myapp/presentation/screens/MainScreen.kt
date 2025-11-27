package com.example.myapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
// УВАГА НА ІМПОРТИ НИЖЧЕ:
import com.example.myapp.presentation.MainViewModel
import com.example.myapp.presentation.components.CategoryItem
import com.example.myapp.presentation.components.PlaceItem

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {
    val categories = viewModel.categories
    val places = viewModel.visiblePlaces
    val selectedCategory = viewModel.selectedCategory

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Категорії",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    CategoryItem(
                        category = category,
                        isSelected = category == selectedCategory,
                        onClick = { viewModel.selectCategory(category) }
                    )
                }
            }
        }

        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Ви переглядаєте: ${selectedCategory.name} (${places.size} об'єктів)",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        items(places) { place ->
            PlaceItem(
                place = place,
                onFavoriteClick = { viewModel.toggleFavorite(place.id) }
            )
        }
    }
}