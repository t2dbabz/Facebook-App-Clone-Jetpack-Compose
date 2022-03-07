package com.example.facebookclone.util

enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    N0_ACTION
}

fun String?.toAction(): Action {
    return when {
        this == "ADD" -> {
            Action.ADD
        }
        this == "UPDATE" -> {
            Action.UPDATE
        }

        this == "DELETE" -> {
            Action.DELETE
        }

        this == "DELETE_ALL" -> {
            Action.DELETE_ALL
        }

        this == "UNDO" -> {
            Action.UNDO
        }
        else -> {
            Action.N0_ACTION
        }
    }
}