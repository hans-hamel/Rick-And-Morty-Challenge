package com.hphl.rickandmorty.data.mapper

import com.hphl.rickandmorty.data.dto.CharacterDto
import com.hphl.rickandmorty.data.dto.CharacterResponseDto
import com.hphl.rickandmorty.data.dto.InfoDto
import com.hphl.rickandmorty.domain.model.CharacterModel
import com.hphl.rickandmorty.domain.model.PageInfo
import com.hphl.rickandmorty.domain.model.PagedCharacters

fun CharacterDto.toDomain(): CharacterModel {
    return CharacterModel(
        id = id,
        name = name,
        status = status,
        species = species,
        image = image
    )
}

fun CharacterResponseDto.toDomain(): PagedCharacters {
    return PagedCharacters(
        characters = results.map { it.toDomain() },
        pageInfo = info.toDomain()
    )
}

fun InfoDto.toDomain(): PageInfo {
    return PageInfo(
        nextPage = extractPageNumber(this.next),
        count = this.count,
        totalPages = this.pages,
        previousPage = extractPageNumber(this.prev),
    )
}

private fun extractPageNumber(nextUrl: String?): Int? {
    return nextUrl
        ?.substringAfter("page=", "")
        ?.toIntOrNull()
}