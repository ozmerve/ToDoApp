package com.merveoz.todoapp.data.model

data class Note(
    val id: Int,
    val title: String,
    val description: String,
    val priorityColorId: Int,
    var isCecked: Boolean = false
)
