package com.teamsparta.todoprojects.todo.controller

import com.teamsparta.todoprojects.todo.dto.CreateTodoRequest
import com.teamsparta.todoprojects.todo.dto.TodoResponse
import com.teamsparta.todoprojects.todo.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/todo")
@RestController
class TodoController (
    private val todoService: TodoService
)
{
    @PostMapping
    fun createTodo(@RequestBody createtodoRequest: CreateTodoRequest): ResponseEntity <TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoService.createTodo(createtodoRequest))
    }

}