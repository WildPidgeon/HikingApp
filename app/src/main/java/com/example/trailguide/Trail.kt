package com.example.trailguide

data class Trail(
    val name: String,
    val imageResId: Int,
    val description: String,
    val stages: List<String>
)
