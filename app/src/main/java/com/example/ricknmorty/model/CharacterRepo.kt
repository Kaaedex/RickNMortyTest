package com.example.ricknmorty.model

import com.example.ricknmorty.model.dtos.CharacterResponse
import com.example.ricknmorty.model.local.CharacterItem
import com.example.ricknmorty.model.mapper.CharacterMapper
import com.example.ricknmorty.util.Resource
import kotlinx.coroutines.Dispatchers


import kotlinx.coroutines.withContext
import retrofit2.Response

object CharacterRepo
{
    private val service: CharacterService by lazy { RetrofitClass.getCharacterService()}
    private val mapper: CharacterMapper = CharacterMapper()
//    private val categoryMealMapper: CategoryMealMapper

    suspend fun getCharacters(): Resource<List<CharacterItem>> = withContext(Dispatchers.IO){

        val queryResponse: Response<CharacterResponse> =
        service.getCharacters().execute()


        return@withContext if (queryResponse.isSuccessful) {

            val repoSuccessResponse = queryResponse.body() ?: CharacterResponse()
            val characterList: List<CharacterItem> = repoSuccessResponse.map{ mapper(it) }

            Resource.Success(characterList)
        } else {
            Resource.Error(queryResponse.message())

    }
    }

   /* suspend fun getMealInCategory(category: CharacterItem): Resource<List<CategoryMeal>> =
        withContext(Dispatchers.IO) {
            val categoryMealResponse = service.getMealFromCategory(category.strCategory).execute()
            if (categoryMealResponse.iSSuccessful){
                val mealsInCategoryResponse =
                    categoryMealResponse.body()?.categoryMeals ?: emptyList()
                    Resource.Success(
                        mealsInCategoryResponse.map { categoryMealMapper(it)}

                    )

            }
            else {
                Resource.Error(categoryMealResponse.message())
            }

        }*/

}