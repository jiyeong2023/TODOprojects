package com.teamsparta.todoprojects.comment.dto

import java.time.LocalDateTime

data class UpdateCommentRequest (
    val user: String,
    val password: String,
    var description : String
)