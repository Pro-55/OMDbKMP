package com.papslabs.omdb_kmp.data.network.api.impl

import com.papslabs.omdb_kmp.data.network.api.contract.OMDbKMPApi
import com.papslabs.omdb_kmp.data.network.model.NetworkSearchResult
import com.papslabs.omdb_kmp.data.network.model.Response
import com.papslabs.omdb_kmp.domain.model.Type
import com.papslabs.omdb_kmp.util.BuildConfig
import com.papslabs.omdb_kmp.util.extensions.get
import com.papslabs.omdb_kmp.util.wrappers.safeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter

class OMDbKMPApiImpl(
    private val client: HttpClient
): OMDbKMPApi {

    override suspend fun searchContent(
        title: String,
        page: Int,
        type: Type
    ): Response<NetworkSearchResult> = safeCall {
        val response = client.get<NetworkSearchResult> {
            parameter("apiKey", BuildConfig.ApiKey)
            parameter("s", title)
            parameter("type", type)
            parameter("page", page)
        }
        Response.Success(response)
    }
}