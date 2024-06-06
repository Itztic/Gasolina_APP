package com.cdp.gasolina_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cdp.gasolina_app.API.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCodigoPostal: EditText = findViewById(R.id.etCodigoPostal)
        val btnBuscar: Button = findViewById(R.id.btnBuscar)
        val tvResultados: TextView = findViewById(R.id.tvResultados)

        // variables para el error:
        //val errorLayout = findViewById<LinearLayout>(R.layout.error_layout)
        //val btnRetry = findViewById<Button>(R.id.button_reload)

        btnBuscar.setOnClickListener {
            val codigoPostal = etCodigoPostal.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                val response = RetrofitInstance.apiService.getEstaciones()
                if (response.isSuccessful) {
                    val estaciones = response.body()?.listaEESSPrecio
                    val estacionesFiltradas = estaciones?.filter { it.codigoPostal == codigoPostal }
                    runOnUiThread {
                        if (!estacionesFiltradas.isNullOrEmpty()) {
                            tvResultados.text = estacionesFiltradas.joinToString("\n") { it.rotulo }
                        } else {
                            tvResultados.text = "No se encontraron gasolineras para el código postal $codigoPostal"
                        }
                    }
                } else {
                    runOnUiThread {
                        tvResultados.text = "Error al obtener los datos."
                    }
                }
            }
        }
    }
}
