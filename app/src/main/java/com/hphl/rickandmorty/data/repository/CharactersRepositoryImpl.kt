package com.hphl.rickandmorty.data.repository

import com.hphl.rickandmorty.data.api.RickAndMortyApiService
import com.hphl.rickandmorty.data.mapper.toDomain
import com.hphl.rickandmorty.domain.model.PagedCharacters
import com.hphl.rickandmorty.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor (
    private val apiService: RickAndMortyApiService
): CharactersRepository {
    override suspend fun getCharacters(page: Int): PagedCharacters {
        return apiService
            .getCharacters(page)
            .toDomain()
    }
}