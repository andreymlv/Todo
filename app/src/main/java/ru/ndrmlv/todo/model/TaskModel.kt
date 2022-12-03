package ru.ndrmlv.todo.model

data class TaskModel(
    val completed: Boolean,
    val task: String,
    val subtasks: List<TaskModel>
)
