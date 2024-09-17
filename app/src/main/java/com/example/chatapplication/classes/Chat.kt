package com.example.chatapplication.classes

class Chat(val contact: Contact, private val messages: List<Message>) {
    fun getLastMessage(): Message {
        return this.messages[0]
    }
}