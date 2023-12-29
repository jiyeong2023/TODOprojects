package com.teamsparta.todoprojects.todo.service

import com.teamsparta.todoprojects.todo.dto.CreateTodoRequest
import com.teamsparta.todoprojects.todo.dto.TodoResponse

interface TodoService {
    fun createTodo(request: CreateTodoRequest) : TodoResponse }

//    fun getAllTodoList(): List<TodoResponse>
//
//    fun getTodoById(todoId: Long): TodoResponse

//    fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse
//
//    fun deleteTodo(todoId: Long)

//    fun getTodoprojectsApplication(
//        todoId: Long,
//        applicationId: Long
//    ): TodoProjectsApplicationResponse

//    fun getTodoprojectsApplication(todoId: Long): List<TodoprojectsApplication>

//    fun updateCourseApplicationStatus(
//        courseId: Long,
//        applicationId: Long,
//        request: UpdateTodoApplicationStatusRequest
//    ): TodoprojectsApplicationResponse
