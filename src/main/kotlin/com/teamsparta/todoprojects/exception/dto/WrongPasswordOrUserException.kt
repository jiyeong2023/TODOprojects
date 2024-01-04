package com.teamsparta.todoprojects.exception.dto

import org.springframework.data.jpa.domain.AbstractPersistable_.id

class WrongPasswordOrUserException(val modelName: String, val id: Long?):
    RuntimeException("Wrong password or user for $modelName with given id: $id") {
}