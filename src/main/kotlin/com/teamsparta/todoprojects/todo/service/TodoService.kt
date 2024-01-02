package com.teamsparta.todoprojects.todo.service

import com.teamsparta.todoprojects.todo.dto.CreateTodoRequest
import com.teamsparta.todoprojects.todo.dto.TodoResponse
import com.teamsparta.todoprojects.todo.dto.UpdateTodoRequest

interface TodoService {
    fun createTodo(request: CreateTodoRequest) : TodoResponse
    fun getAllTodoList(): List<TodoResponse>
    fun getTodoByID(todoId: Long): TodoResponse
    fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse
    fun deleteTodo(todoId: Long)
}
