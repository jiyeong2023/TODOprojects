package com.teamsparta.todoprojects.comment.model

import com.teamsparta.todoprojects.comment.dto.CommentResponse
import com.teamsparta.todoprojects.todo.model.Todo
import jakarta.persistence.*
import jakarta.persistence.GenerationType
import java.time.LocalDateTime

@Entity
@Table(name="comment")
class Comment(
    @ManyToOne
    @JoinColumn(name = "todo_id", nullable = false)
    var todo: Todo,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "user_id", nullable = false)
    var user: String,

    @Column(name = "description", nullable = false)
    var description: String,

    @Column(name = "created_date", nullable = false)
    var createdDate: LocalDateTime = LocalDateTime.now(),
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?= null
}

fun Comment.toResponse(): CommentResponse {
    return CommentResponse(
        id = id!!,
        user = user,
        description = description,
        createdDate
    )
}