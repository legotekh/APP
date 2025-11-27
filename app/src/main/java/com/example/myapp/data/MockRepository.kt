package com.example.myapp.data

class MockRepository {
    fun getCategories(): List<Category> {
        val realCategories = listOf(
            Category(0, "Всі"),
            Category(1, "Парки"),
            Category(2, "Кафе"),
            Category(3, "Музеї"),
            Category(4, "Готелі")
        )

        val dummyCategories = List(15) { index ->
            Category(
                id = 100 + index, // Даємо унікальні ID (100, 101, 102...)
                name = "Інше ${index + 1}"
            )
        }

        return realCategories + dummyCategories
    }

    fun getPlaces(): List<Place> {
        return listOf(
            Place(1, 1, "Центральний Парк", "Великий зелений парк у центрі міста."),
            Place(2, 2, "Кав'ярня 'Арома'", "Найкраща кава та круасани."),
            Place(3, 3, "Історичний Музей", "Експонати з давніх часів."),
            Place(4, 1, "Ботанічний Сад", "Рідкісні рослини та квіти."),
            Place(5, 2, "Бургерна Джо", "Смачні бургери та напої."),
            Place(6, 4, "Готель 'Плаза'", "5-зірковий готель з басейном."),
            Place(7, 3, "Галерея Мистецтв", "Сучасне мистецтво."),
            Place(8, 2, "Піцерія Маріо", "Італійська піца на дровах."),
            Place(9, 1, "Сквер Перемоги", "Тихе місце для відпочинку."),
            Place(10, 4, "Хостел Друзі", "Бюджетний варіант для туристів.")
        )
    }
}