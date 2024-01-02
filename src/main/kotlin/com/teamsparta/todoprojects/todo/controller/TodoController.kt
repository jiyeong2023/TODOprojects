package com.teamsparta.todoprojects.todo.controller

import com.teamsparta.todoprojects.exception.dto.ErrorResponse
import com.teamsparta.todoprojects.exception.dto.ModelNotFoundException
import com.teamsparta.todoprojects.todo.dto.CreateTodoRequest
import com.teamsparta.todoprojects.todo.dto.TodoResponse
import com.teamsparta.todoprojects.todo.dto.UpdateTodoRequest
import com.teamsparta.todoprojects.todo.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/todo")
@RestController
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping
    fun getTodoList(): ResponseEntity<List<TodoResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getAllTodoList())
    }

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getTodoByID(todoId))
    }
    @ExceptionHandler(ModelNotFoundException::class)
    fun handleModelNotFoundException(e: ModelNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(e.message))
    }

    @PostMapping
    fun createTodo(@RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoService.createTodo(createTodoRequest))
    }

    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.updateTodo(todoId, updateTodoRequest))
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: Long): ResponseEntity<Unit> {
        todoService.deleteTodo(todoId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}