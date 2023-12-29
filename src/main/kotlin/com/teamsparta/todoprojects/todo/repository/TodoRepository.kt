package com.teamsparta.todoprojects.todo.repository

import com.teamsparta.todoprojects.todo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {

}