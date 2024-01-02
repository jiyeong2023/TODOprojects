package com.teamsparta.todoprojects.todo.service

import com.teamsparta.todoprojects.exception.dto.ModelNotFoundException
import com.teamsparta.todoprojects.todo.dto.CreateTodoRequest
import com.teamsparta.todoprojects.todo.dto.TodoResponse
import com.teamsparta.todoprojects.todo.dto.UpdateTodoRequest
import com.teamsparta.todoprojects.todo.model.Todo
import com.teamsparta.todoprojects.todo.model.toResponse
import com.teamsparta.todoprojects.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository
) : TodoService {
    override fun getAllTodoList(): List<TodoResponse> {

        return todoRepository.findAll().map { it.toResponse() }
    }

    override fun getTodoByID(todoId: Long): TodoResponse {

        val todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        return todo.toResponse()
    }

    @Transactional
    override fun createTodo(request: CreateTodoRequest): TodoResponse {

        return todoRepository.save(
            Todo(
                title = request.title,
                description = request.description,
                createdDate = LocalDateTime.now(),
                user = request.user,
                password = request.password,

            )
        ).toResponse()
    }

    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {

        val todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        val (title, description, user) = request

        todo.title = title
        if (description != null) {
            todo.description = description
        }
        todo.user = user

        return todoRepository.save(todo).toResponse()
    }

    override fun deleteTodo(todoId: Long) {

        val todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        todoRepository.delete(todo)
    }

}