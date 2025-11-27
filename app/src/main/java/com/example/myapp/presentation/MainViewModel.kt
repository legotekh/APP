package com.example.myapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapp.data.Category
import com.example.myapp.data.MockRepository

class MainViewModel : ViewModel() {
    private val repository = MockRepository()
    private val allPlaces = repository.getPlaces()

    var categories by mutableStateOf(repository.getCategories())
        private set

    var selectedCategory by mutableStateOf(categories.first())
        private set

    var visiblePlaces by mutableStateOf(allPlaces)
        private set

    fun selectCategory(category: Category) {
        selectedCategory = category
        visiblePlaces = if (category.id == 0) {
            allPlaces
        } else {
            allPlaces.filter { it.categoryId == category.id }
        }
    }

    fun toggleFavorite(placeId: Int) {
        visiblePlaces = visiblePlaces.map {
            if (it.id == placeId) it.copy(isFavorite = !it.isFavorite) else it
        }
    }
}