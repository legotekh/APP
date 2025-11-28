package com.example.myapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapp.data.CategoryModel
import com.example.myapp.data.PlaceModel

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    viewModel: AppViewModel = viewModel() // Автоматично беремо ViewModel
) {
    val categories = viewModel.categories
    val places = viewModel.places

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp), // Відступи по краях екрану
        verticalArrangement = Arrangement.spacedBy(16.dp) // Відстань між картками
    ) {
        item {
            Text(
                text = "Категорії",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    CategoryItem(category)
                }
            }
        }

        item {
            Text(
                text = "Популярні місця",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        items(places) { place ->
            PlaceItem(place)
        }
    }
}


@Composable
private fun CategoryItem(category: CategoryModel) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = CircleShape, // Круглі кнопки виглядають краще
        modifier = Modifier.height(40.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = category.name,
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
private fun PlaceItem(place: PlaceModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Gray.copy(alpha = 0.3f))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = place.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = place.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    maxLines = 2
                )
            }
        }
    }
}