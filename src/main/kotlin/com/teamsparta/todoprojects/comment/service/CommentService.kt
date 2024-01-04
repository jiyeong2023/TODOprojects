package com.teamsparta.todoprojects.comment.service

import com.teamsparta.todoprojects.comment.dto.CommentResponse
import com.teamsparta.todoprojects.comment.dto.CreateCommentRequest
import com.teamsparta.todoprojects.comment.dto.DeleteCommentRequest
import com.teamsparta.todoprojects.comment.dto.UpdateCommentRequest


interface CommentService {
    fun createComment(todoId: Long, request: CreateCommentRequest): CommentResponse

    fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun deleteComment(commentId: Long, request: DeleteCommentRequest)
}