package com.papslabs.omdb_kmp.util.wrappers

import com.papslabs.omdb_kmp.data.network.model.Response
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.util.network.UnresolvedAddressException

suspend fun <T> safeCall(block: suspend () -> Response<T>): Response<T> {
    return try {
        block.invoke()
    } catch (e: UnresolvedAddressException) {
        Response.UnknownHostException()
    } catch (e: RedirectResponseException) {
        Response.InvalidPathException()
    } catch (e: ClientRequestException) {
        Response.InvalidRequestException()
    } catch (e: ServerResponseException) {
        Response.ServerException()
    } catch (e: HttpRequestTimeoutException) {
        Response.RequestTimeoutException()
    } catch (e: Exception) {
        Response.UnknownException()
    }
}