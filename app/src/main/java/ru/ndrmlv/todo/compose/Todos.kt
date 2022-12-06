package ru.ndrmlv.todo.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ndrmlv.todo.model.TaskGroup

@Composable
fun Todos(tasks: List<TaskGroup>, completedTasks: List<TaskGroup>) {
    LazyColumn {
        // Uncompleted with subtasks offset
        items(tasks) { task ->
            task.View(32.dp)
        }
        if (completedTasks.isNotEmpty()) {
            item {
                CompletedCard(completedTasks)
            }
        }
        item {
            Spacer(modifier = Modifier.height(84.dp))
        }
    }
}