package com.example.eduapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaCursos(modifier: Modifier = Modifier) {

    var busqueda by remember { mutableStateOf("") }
    var filtro by remember { mutableStateOf("Todos") }

    val azul = Color(0xFF243DE5)

    val cursos = listOf(
        Triple("HTML y CSS", "Código", "12 lecciones"),
        Triple("Diseño UI", "Diseño", "8 lecciones"),
        Triple("JavaScript Básico", "Código", "15 lecciones")
    )

    val cursosFiltrados = cursos.filter { curso ->
        (filtro == "Todos" || curso.second == filtro) &&
                curso.first.contains(busqueda, ignoreCase = true)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        OutlinedTextField(
            value = busqueda,
            onValueChange = { busqueda = it },
            placeholder = {
                Text("Buscar curso...")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("Todos", "Código", "Diseño").forEach { opcion ->

                FilterChip(
                    selected = filtro == opcion,
                    onClick = { filtro = opcion },
                    label = {
                        Text(opcion)
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = azul,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Cursos Disponibles",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(cursosFiltrados) { curso ->

                TarjetaCurso(
                    nombre = curso.first,
                    categoria = curso.second,
                    lecciones = curso.third
                )
            }
        }
    }
}

@Composable
fun TarjetaCurso(
    nombre: String,
    categoria: String,
    lecciones: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "📘",
                    fontSize = 28.sp
                )

                Text(
                    text = lecciones,
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = nombre,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = categoria,
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF243DE5)
                ),
                shape = RoundedCornerShape(9.dp)
            ) {
                Text("Ver curso →")
            }
        }
    }
}