package com.cdp.gasolina_app.API

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/")
    suspend fun getDatos(): Response<JsonData>
}
