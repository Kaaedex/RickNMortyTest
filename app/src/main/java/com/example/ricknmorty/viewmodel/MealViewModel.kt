package com.example.ricknmorty.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ricknmorty.model.local.CategoryMeal
import com.example.ricknmorty.model.CharacterRepo
import com.example.ricknmorty.model.local.CharacterItem
import com.example.ricknmorty.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MealViewModel (
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val repo = CharacterRepo
    private val TAG = "MealViewModel"

    private val _viewState: MutableStateFlow<Resource<List<CharacterItem>>> = MutableStateFlow(
        Resource.Loading())
    val viewState: StateFlow<Resource<List<CharacterItem>>> get() = _viewState

    init {

        getData()

    }

    private fun getData() = viewModelScope.launch {

        val characterItem = savedStateHandle.get<String>("category") ?: ""
        //Looking for individual item / response
        _viewState.value = repo.getCharacters()
    }
}
