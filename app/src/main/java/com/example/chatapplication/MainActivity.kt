package com.example.chatapplication

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chatapplication.classes.Chat
import com.example.chatapplication.classes.Contact
import com.example.chatapplication.classes.Message
import com.example.chatapplication.ui.theme.ChatApplicationTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatApplicationTheme {
                Scaffold(
                    topBar = {
                        TopAppBar()
                    },
                    floatingActionButton = {
                        FloatingActionButton()
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        ChatContainer()
                    }
                }
            }
        }
    }
}

@Composable
fun TopAppBar() {
    Text(text = "TOP BAR")
}

@Composable
fun FloatingActionButton() {
    Box(
        modifier = Modifier
            .size(64.dp)
            .background(Color.Gray, CircleShape)
            .padding(8.dp)
    )
}

@Composable
fun ChatContainer() {
    val chatList = listOf<Chat>(
        Chat(Contact("Juan Pérez", 1), listOf(Message("Hola, ¿cómo estás?", Date()), Message("¿Vas a venir a la reunión?", Date()))),
        Chat(Contact("María García", 2), listOf(Message("Hola, esto es un mensaje de prueba", Date()), Message("Nos vemos mañana", Date()))),
        Chat(Contact("Carlos Sánchez", 3), listOf(Message("Hey, ¿qué tal?", Date()), Message("¿Vamos a salir hoy?", Date()))),
        Chat(Contact("Ana López", 4), listOf(Message("Hola, ¿me puedes ayudar?", Date()), Message("Gracias por tu ayuda", Date()))),
        Chat(Contact("Luis Fernández", 5), listOf(Message("Reunión a las 3 PM", Date()), Message("¿Confirma asistencia?", Date()))),
        Chat(Contact("Elena Ruiz", 6), listOf(Message("¿Tienes tiempo para hablar?", Date()), Message("Llamaré más tarde", Date()))),
        Chat(Contact("Pedro Martínez", 7), listOf(Message("Nuevo proyecto disponible", Date()), Message("Revisa el documento adjunto", Date()))),
        Chat(Contact("Laura Gómez", 8), listOf(Message("Hola, ¿cómo estás?", Date()), Message("Nos vemos pronto", Date()))),
        Chat(Contact("Ricardo Ortiz", 9), listOf(Message("Reunión cancelada", Date()), Message("Nueva fecha pendiente", Date()))),
        Chat(Contact("Paula Morales", 10), listOf(Message("Envío pendiente", Date()), Message("Confirmar recepción", Date()))),
        Chat(Contact("David Ramírez", 11), listOf(Message("¡Feliz cumpleaños!", Date()), Message("Espero que tengas un gran día", Date()))),
        Chat(Contact("Sofía Herrera", 12), listOf(Message("Nuevo mensaje recibido", Date()), Message("Por favor revisa", Date()))),
        Chat(Contact("Gabriel Torres", 13), listOf(Message("Actualización disponible", Date()), Message("Verificar cambios", Date()))),
        Chat(Contact("Daniela Díaz", 14), listOf(Message("Pedido confirmado", Date()), Message("Fecha de entrega estimada", Date()))),
        Chat(Contact("Javier Castro", 15), listOf(Message("Evento el próximo viernes", Date()), Message("Confirma tu asistencia", Date()))),
        Chat(Contact("Martín Vega", 16), listOf(Message("Revisa el informe", Date()), Message("Enviado al correo", Date()))),
        Chat(Contact("Carmen Rivas", 17), listOf(Message("¿Tienes tiempo mañana?", Date()), Message("Llamaré a las 10 AM", Date()))),
        Chat(Contact("Raúl Jiménez", 18), listOf(Message("Nuevo cliente asignado", Date()), Message("Revisar detalles en el CRM", Date()))),
        Chat(Contact("Valeria Méndez", 19), listOf(Message("Invitación a reunión", Date()), Message("Confirma tu asistencia", Date()))),
        Chat(Contact("Andrea Paredes", 20), listOf(Message("¡Feliz aniversario!", Date()), Message("Espero que lo disfrutes", Date()))),
    )
    LazyColumn() {
        items(chatList) { chat ->
            ChatPreview(chat = chat)
        }
    }
}

private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

@Composable
fun ChatPreview(chat: Chat) {
    val lastMessage = chat.getLastMessage()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Imagen de perfil
//        Image(
//            painter = painterResource(id = chat.contact.profileImg),
//            contentDescription = "Imagen de perfil",
//            modifier = Modifier
//                .size(48.dp)
//                .padding(8.dp),
//            contentScale = ContentScale.Crop
//        )
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color.Gray, CircleShape)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // Información del contacto y mensaje
        Column {
            Text(
                text = chat.contact.name,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            lastMessage?.let {
                Text(
                    text = it.text,
                    color = Color.Gray
                )
                Text(
                    text = dateFormat.format(it.date),
                    color = Color.LightGray
                )
            }
        }
    }
}