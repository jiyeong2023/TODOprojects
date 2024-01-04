package com.teamsparta.todoprojects.comment.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.teamsparta.todoprojects.comment.model.Comment

interface CommentRepository: JpaRepository<Comment, Long> {

//    fun findByCommentIdAndId(userId: Long, Id: Long): Comment? {}

}