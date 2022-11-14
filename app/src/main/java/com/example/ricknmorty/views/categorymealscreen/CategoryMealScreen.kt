package com.example.ricknmorty.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ricknmorty.util.Resource
import com.example.ricknmorty.viewmodel.MealViewModel


@Composable
fun CategoryMealScreen( mealViewModel: MealViewModel = viewModel() ) {


    when(val viewState = mealViewModel.viewState.collectAsState().value){

        is Resource.Error -> { }
        is Resource.Loading -> {

            CircularProgressIndicator()
        }
        is Resource.Success -> {
            ShowMeal()

        }
    }


}

@Composable
fun ShowMeal(){

    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
/*
        items(state.categoryMeals) {
                meal -> Text(text = "Why No Meals?")

    }

 */

}