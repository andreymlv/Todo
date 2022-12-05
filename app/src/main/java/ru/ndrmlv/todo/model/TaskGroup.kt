package ru.ndrmlv.todo.model

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.util.*

class TaskGroup(
    private val root: Task,
    private val subtasks: List<Task>,
    private val uid: UUID = UUID.randomUUID(),
) {
    fun complete(): TaskGroup {
        return TaskGroup(root.complete(), subtasks.map { it.complete() }, uid)
    }

    @Composable
    fun View(padding: Dp = 0.dp) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(), shape = RoundedCornerShape(16.dp)
        ) {
            Column {
                root.View()
                subtasks.forEach {
                    Box(modifier = Modifier.padding(start = padding)) { it.View() }
                }
            }
        }
    }
}
