package com.hphl.rickandmorty.presentation

import com.hphl.rickandmorty.domain.model.CharacterModel

object CharactersConstants {
    val CHARACTER_RICK = CharacterModel(
        id = 1,
        name = "Rick Sanchez",
        status = "Alive",
        species = "Human",
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
    )
}