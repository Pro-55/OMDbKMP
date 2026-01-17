package com.papslabs.omdb_kmp.data.network.api.contract

import com.papslabs.omdb_kmp.data.network.model.NetworkContent
import com.papslabs.omdb_kmp.data.network.model.NetworkSearchResult
import com.papslabs.omdb_kmp.data.network.model.Response
import com.papslabs.omdb_kmp.domain.model.Type

interface OMDbKMPApi {
    suspend fun searchContent(
        title: String,
        page: Int,
        type: Type
    ): Response<NetworkSearchResult>

    suspend fun getDetails(
        id: String,
        plot: String
    ): Response<NetworkContent>
}