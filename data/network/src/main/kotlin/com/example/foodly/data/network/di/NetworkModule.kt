package com.example.foodly.data.network.di

import com.example.foodly.data.network.BuildConfig
import com.example.foodly.data.network.api.ApiEndpoints
import com.example.foodly.data.network.service.RecipesService
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single<HttpClient> {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    coerceInputValues = true
                    encodeDefaults = false
                })
            }
            defaultRequest {
                header("Content-Type", "application/json")
                url {
                    protocol = URLProtocol.HTTPS
                    host = ApiEndpoints.BACKEND_URL
                    parameters.append("apiKey", BuildConfig.key)
                }
            }
            install(HttpCookies)
            install(HttpCache)
            if (BuildConfig.DEBUG) {
                install(Logging) {
                    logger = Logger.ANDROID
                    level = LogLevel.ALL
                }
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 100000
            }
        }
    }
    single<RecipesService> { RecipesService(get<HttpClient>()) }
}
