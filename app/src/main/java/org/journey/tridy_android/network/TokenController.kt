package org.journey.tridy_android.network

import org.journey.tridy_android.network.dto.ResponseAuthDTO
import retrofit2.Response

interface TokenController {
    fun fetchAccessToken(): Response<ResponseAuthDTO>
}