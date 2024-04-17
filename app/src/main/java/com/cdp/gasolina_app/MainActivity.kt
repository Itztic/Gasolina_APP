package com.cdp.gasolina_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.cdp.gasolina_app.ui.theme.Gasolina_APPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gasolina_APPTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }

    @Composable
    fun MainScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            var city by remember { mutableStateOf("") }

            // Recuadro de introducción de texto
            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("Introduce tu ciudad") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón de entrada
            Button(
                onClick = {
                    // Lógica para realizar la búsqueda de gasolineras
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                Text("Buscar")
            }

            // Lista de favoritos
            FavoritesList()
        }
    }

    @Composable
    fun FavoritesList() {
        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            items(10) { index ->
                Text(
                    text = "Favorito $index",
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Gasolina_APPTheme {
            MainScreen()
        }
    }
}
