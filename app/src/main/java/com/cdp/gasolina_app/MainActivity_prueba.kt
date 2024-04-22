package com.cdp.gasolina_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cdp.gasolina_app.ui.theme.Gasolina_APPTheme
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class MainActivity_prueba : ComponentActivity() {

    private lateinit var cityEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var logoImageView: ImageView
    private lateinit var favoritesTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gasolina_APPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }

                cityEditText = findViewById(R.id.cityEditText)
                searchButton = findViewById(R.id.searchButton)
                //logoImageView = findViewById(R.id.logoImageView)
                favoritesTextView = findViewById(R.id.favoritesTextView)

                // Configurar acción del botón de búsqueda
                searchButton.setOnClickListener {
                    val city = cityEditText.text.toString().trim()
                    // Aquí puedes hacer la lógica para buscar gasolineras en la ciudad especificada
                }
            }
        }
    }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Gasolina_APPTheme {
            Greeting("Android")
        }
    }
}