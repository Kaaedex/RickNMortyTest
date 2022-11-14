package com.example.ricknmorty.model.mapper

sealed interface Mapper<in DTO, out ENTITY>{
    operator fun invoke(dtp: DTO): ENTITY
}