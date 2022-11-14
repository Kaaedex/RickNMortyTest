package com.example.ricknmorty.model.mapper

import com.example.ricknmorty.model.dtos.CharacterDTO
import com.example.ricknmorty.model.local.CharacterItem

class CharacterMapper : Mapper<CharacterDTO, CharacterItem> {
    override fun invoke(dto: CharacterDTO): CharacterItem = with(dto){

        CharacterItem(


        )

    }
}