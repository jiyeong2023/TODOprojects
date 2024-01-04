package com.teamsparta.todoprojects.comment.dto

import java.time.LocalDateTime

data class CommentResponse (
    val id: Long,
    val user: String,
    val description: String,
    val createdDate: LocalDateTime,
)
