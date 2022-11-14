package com.example.ricknmorty.views.categoryscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.ricknmorty.model.local.CharacterItem
import com.example.ricknmorty.util.Resource
import com.example.ricknmorty.viewmodel.CharacterViewModel
import java.util.Locale.Category

@Composable
fun CategoryScreen(navigate: (category: String)-> Unit,
    viewModel: CharacterViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
                   ) {



    when(val viewState = viewModel.viewState.collectAsState().value){
        is Resource.Error -> {

            viewState.message
        }
        is Resource.Loading -> {
            //Load that component
            //Circular Progress Bar
            CircularProgressIndicator()
        }
        is Resource.Success -> {
            ShowItems(viewState.data, navigate)
        }

    }
}
@Composable
fun ShowItems( data: List<CharacterItem>, navigate: (characterItem: String) -> Unit
) {

    LazyColumn(){
        items(data) { characterItem: CharacterItem ->
            Row(
                modifier = Modifier.clickable {
                    navigate(characterItem)

                }){}

        }

    }

}