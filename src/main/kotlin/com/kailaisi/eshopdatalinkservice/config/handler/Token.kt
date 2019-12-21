package com.kailaisi.eshopdatalinkservice.config.handler

enum class Token {
    SUCCESS, FAILED;

    val isSuccess: Boolean
        get() = this == SUCCESS

    val isFailed: Boolean
        get() = this == FAILED
}