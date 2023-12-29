package com.teamsparta.todoprojects.todo.service

import com.teamsparta.todoprojects.todo.dto.CreateTodoRequest
import com.teamsparta.todoprojects.todo.dto.TodoResponse
import com.teamsparta.todoprojects.todo.model.Todo
import com.teamsparta.todoprojects.todo.model.toResponse
import com.teamsparta.todoprojects.todo.repository.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository
) : TodoService {
    @Transactional
    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        return todoRepository.save(
            Todo(
                title = request.title,
                description = request.description,
                user = request.user,
                createdDate = request.createdDate,
                password = request.password,
            )
        ).toResponse()
    }

//        @Transactional
//        override fun updateCourse(courseId: Long, request: UpdateCourseRequest): CourseResponse {
//            val course = courseRepository.findByIdOrNull(courseId) ?: throw ModelNotFoundException("Course", courseId)
//            val (title, description) = request
//
//            course.title = title
//            course.description = description
//
//            return todoRepository.save(course).toResponse()
//        }

}