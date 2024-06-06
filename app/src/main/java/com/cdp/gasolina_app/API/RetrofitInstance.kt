package com.cdp.gasolina_app.API

import com.cdp.gasolina_app.model.EstacionResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/")
    suspend fun getEstaciones(): Response<EstacionResponse>
}

object RetrofitInstance {
    val apiService: ApiService = Retrofit.Builder()
        .baseUrl("https://sedeaplicaciones.minetur.gob.es/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(ApiService::class.java)
}