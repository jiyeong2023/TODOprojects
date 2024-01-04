package com.teamsparta.todoprojects.exception.dto


class WrongPasswordOrUserException(val modelName: String,):
    RuntimeException("Wrong password or user for $modelName with given id:  $commentId") {
}