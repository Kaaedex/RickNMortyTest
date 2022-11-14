package com.example.ricknmorty.navigation

sealed class Screens(val route: String){
    object CategoriesScreen : Screens("categories_route")
    object MealScreen : Screens("meal_route/{category}") {

        fun passCategory(category: String): String {
            return "meal_route/${category}"
        }

    }

}
