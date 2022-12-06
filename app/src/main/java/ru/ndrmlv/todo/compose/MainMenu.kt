package ru.ndrmlv.todo.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import ru.ndrmlv.todo.model.TaskGroup

@Composable
fun MainMenu(tasks: List<TaskGroup>, completedTasks: List<TaskGroup>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("todo") },
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = {/* Open new activity to add new task */ }) {
                Text("+")
            }
        },
        content = { paddingValues ->
            Box(modifier = androidx.compose.ui.Modifier.padding(paddingValues)) {
                Todos(
                    tasks,
                    completedTasks
                )
            }
        },
    )
}