package com.example.eduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.eduapp.components.BarraNavegacion
import com.example.eduapp.components.Encabezado
import com.example.eduapp.screens.PantallaCursos
import com.example.eduapp.screens.PantallaInicio
import com.example.eduapp.screens.PantallaPerfil
import com.example.eduapp.ui.theme.EduAppTheme

var colorTexto = Color.Gray
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            EduAppTheme {

                val pantalla = remember {
                    mutableStateOf("Inicio")
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),

                    bottomBar = {
                        BarraNavegacion(
                            pantallaActual = pantalla.value,
                            onPantallaSeleccionada = {
                                pantalla.value = it
                            }
                        )
                    }

                ) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {

                        Encabezado(pantalla = pantalla.value)

                        when (pantalla.value) {

                            "Inicio" -> {
                                PantallaInicio(
                                    modifier = Modifier.weight(1f)
                                )
                            }

                            "Cursos" -> {
                                PantallaCursos(
                                    modifier = Modifier.weight(1f)
                                )
                            }

                            "Perfil" -> {
                                PantallaPerfil(
                                    modifier = Modifier.weight(1f)
                                )

                            }
                        }
                    }
                }
            }
        }
    }
}