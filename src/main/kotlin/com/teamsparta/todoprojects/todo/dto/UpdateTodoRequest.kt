package com.teamsparta.todoprojects.todo.dto

import java.time.LocalDateTime

data class UpdateTodoRequest(
    val title: String,
    val content: String?,
    val user: String,
    val createddate: LocalDateTime,

)
