package com.example.ricknmorty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ricknmorty.views.CategoryMealScreen
import com.example.ricknmorty.views.categoryscreen.CategoryScreen

@Composable
fun SetUpNavGraph( navController: NavHostController) {

    NavHost(navController = navController,
        startDestination = Screens.CategoriesScreen.route
        ) {

        composable(Screens.CategoriesScreen.route){

            CategoryScreen(navigate = {navController.navigate(Screens.MealScreen.passCategory(it))})
        }

        composable(Screens.MealScreen.route, arguments = listOf(navArgument("category"){
            type = NavType.StringType} )){
            CategoryMealScreen()

        }
    }

}