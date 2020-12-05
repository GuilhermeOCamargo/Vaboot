package com.gocamargo.vaboot.gateway

import com.gocamargo.vaboot.configuration.PropertySource
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

private val client = OkHttpClient()
private val baseUrl = PropertySource["rest.currency.url"]
private val apiKey = PropertySource["FREE_CURRENCY_API_KEY"]
private val BRL = "BRL";

fun getCUrrency(currency: String): Any =
        Request.Builder()
                .url(baseUrl.plus(createQueryParameter(currency)))
                .build()
                .call().body.


private fun createParameter(currency: String): String = BRL.plus("_").plus(currency)
private fun createQueryParameter(currency: String): String = "?q=".plus(createParameter(currency)).plus("apiKey").plus(apiKey)

fun Request.call(): Response =
        client.newCall(this).execute()