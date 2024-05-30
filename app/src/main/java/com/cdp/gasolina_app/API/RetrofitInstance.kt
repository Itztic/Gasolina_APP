package com.cdp.gasolina_app.API

import com.cdp.gasolina_app.model.EstacionResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface apiService {
    @GET("ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/")
    suspend fun getEstaciones(): Response<EstacionResponse>
}

object RetrofitInstance {
    val apiService: apiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://sedeaplicaciones.minetur.gob.es/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiService::class.java)
    }
}