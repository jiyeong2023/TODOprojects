package com.teamsparta.todoprojects.comment.service

import com.teamsparta.todoprojects.comment.dto.CommentResponse
import com.teamsparta.todoprojects.comment.dto.CreateCommentRequest
import com.teamsparta.todoprojects.comment.dto.DeleteCommentRequest
import com.teamsparta.todoprojects.comment.dto.UpdateCommentRequest
import com.teamsparta.todoprojects.comment.repository.CommentRepository
import com.teamsparta.todoprojects.comment.model.Comment
import com.teamsparta.todoprojects.comment.model.toResponse
import com.teamsparta.todoprojects.exception.dto.ModelNotFoundException
import com.teamsparta.todoprojects.exception.dto.WrongPasswordOrUserException
import com.teamsparta.todoprojects.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class CommentServiceImpl(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository
) : CommentService {
    @Transactional
    override fun createComment(todoId: Long, request: CreateCommentRequest): CommentResponse {

        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)

        return commentRepository.save(
            Comment(
                todo = todo,
                user = request.user,
                password = request.password,
                description = request.description
            )
        ).toResponse()
    }

    @Transactional
    override fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse {

        val comment =
            commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)
        val (user, password, description) = request

        if (user != comment.user || password != comment.password) throw WrongPasswordOrUserException("Password", commentId)

        comment.description = description

        return commentRepository.save(comment).toResponse()
    }

    override fun deleteComment(commentId: Long, request: DeleteCommentRequest) {
        val comment =
            commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)
        val (user, password) = request

        if (user != comment.user || password != comment.password) throw WrongPasswordOrUserException("Password", commentId)

        commentRepository.delete(comment)
    }

}