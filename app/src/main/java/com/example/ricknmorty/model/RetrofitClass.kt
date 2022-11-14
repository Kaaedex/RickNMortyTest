package com.example.ricknmorty.model
import android.provider.MediaStore.Audio.Media
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClass {

    private const val BASE_URL = "https://rickandmortyapi.com/api"

    //private val mediaType = MediaType.get("application/json")
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCharacterService(): CharacterService = retrofit.create()
}

