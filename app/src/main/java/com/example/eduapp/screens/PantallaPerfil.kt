
package com.example.eduapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eduapp.R
@Composable
fun PantallaPerfil(modifier: Modifier = Modifier) {

    val azul = Color(0xFF243DE5)

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.foto_perfil),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Alex Mendoza",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "alex@ejemplo.com",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            TarjetaEstadistica(
                numero = "3",
                descripcion = "Cursos",
                color = azul,
                modifier = Modifier.weight(1f)
            )

            TarjetaEstadistica(
                numero = "4",
                descripcion = "Certificados",
                color = azul,
                modifier = Modifier.weight(1f)
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column {

                OpcionPerfil(
                    icono = "✎",
                    titulo = "Editar perfil"
                )

                HorizontalDivider()

                OpcionPerfil(
                    icono = "♧",
                    titulo = "Notificaciones"
                )

                HorizontalDivider()

                OpcionPerfil(
                    icono = "?",
                    titulo = "Ayuda"
                )
            }
        }

        TextButton(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "↪  Cerrar sesión",
                color = Color(0xFFD92D20),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun TarjetaEstadistica(
    numero: String,
    descripcion: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = numero,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )

            Text(
                text = descripcion,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun OpcionPerfil(
    icono: String,
    titulo: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = icono,
            fontSize = 22.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = titulo,
            fontSize = 15.sp,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "›",
            fontSize = 24.sp,
            color = Color.Gray
        )
    }
}
