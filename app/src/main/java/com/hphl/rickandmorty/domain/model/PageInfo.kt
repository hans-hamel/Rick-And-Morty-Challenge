package com.hphl.rickandmorty.domain.model

data class PageInfo(
    val count: Int,
    val totalPages: Int,
    val nextPage: String?,
    val previousPage: String?
)