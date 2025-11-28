package com.example.myapp.presentation

import androidx.lifecycle.ViewModel
import com.example.myapp.data.CategoryModel
import com.example.myapp.data.PlaceModel

class AppViewModel : ViewModel() {

    val categories = listOf(
        CategoryModel(1, "Всі"),
        CategoryModel(2, "Парки"),
        CategoryModel(3, "Кафе"),
        CategoryModel(4, "Музеї"),
        CategoryModel(5, "Готелі"),
        CategoryModel(6, "Ресторани"),
        CategoryModel(7, "Кіно")
    )

    val places = List(20) { index ->
        PlaceModel(
            id = index,
            title = "Локація №${index + 1}",
            description = "Це короткий опис для чудової локації під номером ${index + 1}. Тут дуже гарно."
        )
    }
}