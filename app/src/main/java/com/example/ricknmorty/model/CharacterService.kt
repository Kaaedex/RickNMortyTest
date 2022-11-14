package com.example.ricknmorty.model

import com.example.ricknmorty.model.dtos.CharacterResponse
import retrofit2.http.GET
import retrofit2.Call
interface CharacterService {


    @GET(CHARACTER_ENDPOINT)
    fun getCharacters() : Call<CharacterResponse>


    companion object {

        private const val CHARACTER_ENDPOINT : String = ""
    }
}