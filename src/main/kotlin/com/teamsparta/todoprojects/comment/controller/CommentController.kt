package com.teamsparta.todoprojects.comment.controller

import com.teamsparta.todoprojects.comment.dto.CommentResponse
import com.teamsparta.todoprojects.comment.dto.CreateCommentRequest
import com.teamsparta.todoprojects.comment.dto.DeleteCommentRequest
import com.teamsparta.todoprojects.comment.dto.UpdateCommentRequest
import com.teamsparta.todoprojects.comment.service.CommentService
import com.teamsparta.todoprojects.exception.dto.ErrorResponse
import com.teamsparta.todoprojects.exception.dto.ModelNotFoundException
import com.teamsparta.todoprojects.todo.dto.CreateTodoRequest
import com.teamsparta.todoprojects.todo.dto.TodoResponse
import com.teamsparta.todoprojects.todo.dto.UpdateTodoRequest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/todos/{todoId}/comments")
@RestController
class CommentController(
    private val commentService: CommentService
) {
    @PostMapping
    fun createTodo(
        @PathVariable(value = "todoId") todoId: Long,
        @RequestBody createCommentRequest: CreateCommentRequest): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(todoId, createCommentRequest))
    }

    @PutMapping("/{commentId}")
    fun updateTodo(
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(commentId, updateCommentRequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteTodo(
        @PathVariable commentId: Long,
        deleteCommentRequest: DeleteCommentRequest
    ): ResponseEntity<Unit> {
        commentService.deleteComment(commentId, deleteCommentRequest)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}