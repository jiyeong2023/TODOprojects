package com.teamsparta.todoprojects.todo.model

import com.teamsparta.todoprojects.todo.dto.TodoResponse
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name="todo")
class Todo(
    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "description", nullable = false)
    var description: String,

    @Column(name = "created_date", nullable = false)
    var createdDate: LocalDateTime,

    @Column(name = "user_id", nullable = false)
    var user: String,

    @Column(name = "password", nullable = false)
    var password: String,

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?= null
}
fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        description = description,
        user = user,
        createdDate = LocalDateTime.now()
    )
}