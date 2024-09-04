package com.example.chatapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatapplication.classes.Chat
import com.example.chatapplication.ui.theme.ChatApplicationTheme

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
                        Text(text = "HELLO WORLD")
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
    Text(text = "FLOATING BUTTON")
}

@Composable
fun ChatContainer() {
    val chatList = listOf<Chat>()
    LazyColumn() {
        items(chatList) { chat ->
            ChatPreview(chat = chat)
        }
    }
}

@Composable
fun ChatPreview(chat: Chat) {
    Text("UN CHAT")
}