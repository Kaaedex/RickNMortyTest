package com.example.ricknmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ricknmorty.model.local.CharacterItem
import com.example.ricknmorty.model.CharacterRepo
import com.example.ricknmorty.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val repo = CharacterRepo

    private val _viewState: MutableStateFlow<Resource<List<CharacterItem>>> = MutableStateFlow(Resource.Loading())

    val viewState: StateFlow<Resource<List<CharacterItem>>>
    get() = _viewState

    init {

        getCharacters()
    }

    private fun getCharacters() = viewModelScope.launch{

        _viewState.value = repo.getCharacters()

    }

}