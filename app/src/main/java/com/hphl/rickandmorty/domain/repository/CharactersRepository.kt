package com.hphl.rickandmorty.domain.repository

import com.hphl.rickandmorty.domain.model.PagedCharacters

interface CharactersRepository {
    suspend fun getCharacters(page: Int): PagedCharacters
}