package com.example.celebritylab2.model.entity

data class Celebrity(
    val name: String? = null,
    val gender: String? = null,
    val nationality: String? = null,
    val occupation: List<String>? = null,
    val birthday: String? = null,
    val age: Int? = null,
)