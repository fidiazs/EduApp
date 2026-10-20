package com.example.eduapp.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BarraNavegacion(
    pantallaActual: String,
    onPantallaSeleccionada: (String) -> Unit
) {
    val pantallas = listOf("Inicio", "Cursos", "Perfil")

    NavigationBar(
        containerColor = Color.White
    ) {
        pantallas.forEach { pantalla ->

            NavigationBarItem(
                selected = pantallaActual == pantalla,

                onClick = {
                    onPantallaSeleccionada(pantalla)
                },

                icon = {
                    Text(
                        text = when (pantalla) {
                            "Inicio" -> "🏠"
                            "Cursos" -> "📚"
                            else -> "👤"
                        }
                    )
                },

                label = {
                    Text(text = pantalla)
                }
            )
        }
    }
}