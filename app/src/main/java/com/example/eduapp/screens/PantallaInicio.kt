package com.example.eduapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eduapp.colorTexto

@Composable

fun PantallaInicio (modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "¡Hola, Alex!",
            fontSize = 27.sp,
            color = colorTexto
        )
        Text(
            text = "Bienvenido a tu aula virtual",
            fontSize = 14.sp,
            color = colorTexto

        )
        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxSize(),
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
                        text = "MI CURSO ACTUAL",
                        fontSize = 10.sp,
                        color = colorTexto
                    )

                    Text(
                        text = "60&",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Fundamentos de Diseño",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Continúa donde lo dejaste",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                LinearProgressIndicator(
                    progress = { 0.6f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(7.dp),
                    color = Color(0xFF243DE5),
                    trackColor = Color(0xFFE5E6E9)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(9.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF243DE5)
                    )
                ) {
                    Text(text = "Continuar →")
                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            TarjetaAcceso(
                icono = "📋",
                titulo = "Mis Tareas",
                descripcion = "Actividades pendientes",
                colorIcono = Color(0xFFD4E8FF)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TarjetaAcceso(
                icono = "🎓",
                titulo = "Mis Clases",
                descripcion = "Horarios y sesiones",
                colorIcono = Color(0xFF9BF5C3)
            )
        }
    }
}





@Composable
fun TarjetaAcceso(
    icono: String,
    titulo: String,
    descripcion: String,
    colorIcono: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        colorIcono,
                        RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icono,
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = titulo,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = descripcion,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Text(
                text = "›",
                fontSize = 25.sp,
                color = Color.Gray
            )
        }
    }
}