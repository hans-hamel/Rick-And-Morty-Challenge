package com.hphl.rickandmorty.domain.model

data class CharacterModel (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)