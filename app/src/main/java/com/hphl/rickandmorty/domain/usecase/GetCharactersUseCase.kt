package com.hphl.rickandmorty.domain.usecase

import com.hphl.rickandmorty.domain.model.PagedCharacters
import com.hphl.rickandmorty.domain.repository.CharactersRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke(page: Int): PagedCharacters {
        return repository.getCharacters(page)
    }
}