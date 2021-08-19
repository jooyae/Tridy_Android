package org.journey.tridy_android.network.dto

data class ResponseAuthDTO(
    val accessToken: String,
    val refreshToken: String,
    val userId: String
)
