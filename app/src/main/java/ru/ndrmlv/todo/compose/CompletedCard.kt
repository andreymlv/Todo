package ru.ndrmlv.todo.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import ru.ndrmlv.todo.model.TaskGroup

@Composable
fun CompletedCard(completedTasks: List<TaskGroup>) {
    var foldCompleted by remember { mutableStateOf(true) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .clickable(onClick = {
                foldCompleted = !foldCompleted
            }), shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)

        ) {
            Column {
                Text(text = "Completed (${completedTasks.size})")
            }
            Column(
                modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End
            ) {
                Text(text = if (!foldCompleted) "^" else "v")
            }
        }
    }
    if (!foldCompleted) {
        for (task in completedTasks) {
            Row {
                task.View()
            }
        }
    }
}
