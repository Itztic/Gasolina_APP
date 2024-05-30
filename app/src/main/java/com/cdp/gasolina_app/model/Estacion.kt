package com.cdp.gasolina_app.model


import com.google.gson.annotations.SerializedName

data class EstacionResponse(
    @SerializedName("ListaEESSPrecio") val listaEESSPrecio: List<Estacion>,
    @SerializedName("Fecha") val fecha: String,
    @SerializedName("Nota") val nota: String,
    @SerializedName("ResultadoConsulta") val resultadoConsulta: String
)

data class Estacion(
    @SerializedName("C.P.") val codigoPostal: String,
    @SerializedName("Dirección") val direccion: String,
    @SerializedName("Horario") val horario: String,
    @SerializedName("Latitud") val latitud: String,
    @SerializedName("Localidad") val localidad: String,
    @SerializedName("Longitud (WGS84)") val longitud: String,
    @SerializedName("Margen") val margen: String,
    @SerializedName("Municipio") val municipio: String,
    @SerializedName("Precio Producto") val precioProducto: List<Producto>,
    @SerializedName("Provincia") val provincia: String,
    @SerializedName("Rótulo") val rotulo: String,
    @SerializedName("IDEESS") val ideess: String,
    @SerializedName("IndicePrecio") val indicePrecio: String,
    @SerializedName("TiposCarburante") val tiposCarburante: String
)

data class Producto(
    @SerializedName("tipo") val tipo: String,
    @SerializedName("precio") val precio: String
)
