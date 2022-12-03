package ru.ndrmlv.todo.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ndrmlv.todo.model.TaskModel

@Composable
fun Task(task: TaskModel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), shape = RoundedCornerShape(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = task.completed, onCheckedChange = { /*TODO*/ })
            Text(text = task.task)
        }
    }
}
