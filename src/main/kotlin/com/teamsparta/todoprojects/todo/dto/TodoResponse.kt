package com.teamsparta.todoprojects.todo.dto

import java.time.LocalDateTime

data class TodoResponse (
    val id: Long,
    val title: String,
    var description: String?,
    val user: String,
    val createdDate: LocalDateTime,
)