package com.teamsparta.todoprojects.comment.dto

data class CreateCommentRequest(
    val user: String,
    val password: String,
    var description : String,
)