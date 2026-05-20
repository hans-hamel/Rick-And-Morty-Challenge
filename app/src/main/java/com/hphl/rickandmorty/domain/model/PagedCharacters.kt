package com.hphl.rickandmorty.domain.model

data class PagedCharacters(
    val characters: List<CharacterModel>,
    val pageInfo: PageInfo
)