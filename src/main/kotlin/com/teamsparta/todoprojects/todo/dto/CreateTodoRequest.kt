package com.teamsparta.todoprojects.todo.dto

import java.time.LocalDateTime

data class CreateTodoRequest(
    val id: Long,
    val password: String,
    val title: String,
    val user: String,
    val createdDate: LocalDateTime,
    val description : String,
)
