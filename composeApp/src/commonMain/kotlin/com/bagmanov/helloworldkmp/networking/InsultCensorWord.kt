package com.bagmanov.helloworldkmp.networking

import com.bagmanov.helloworldkmp.util.NetworkError
import com.bagmanov.helloworldkmp.util.Result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException

class InsultCensorWord(
    private val httpClient: HttpClient
) {

    suspend fun censorWords(uncensorWords: String): Result<String, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = "https://www.purgomalum.com/service/json"
            ) {
                parameter("text", uncensorWords)
            }

        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val censoredText = response.body<CensoredTextDto>()
                Result.Success(censoredText.result)
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}