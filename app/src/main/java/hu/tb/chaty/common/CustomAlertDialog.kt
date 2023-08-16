package hu.tb.chaty.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomAlertDialog(
    onDismissListener: () -> Unit,
    confirmButton: () -> Unit,
    buttonTitle: String,
    title: String,
    text: String,
) {
    AlertDialog(
        onDismissRequest = onDismissListener,
        confirmButton = {
            Button(onClick = confirmButton) {
                Text(text = buttonTitle)
            }
        },
        title = {
            Text(text = title)
        },
        text = {
            Text(text = text)
        }
    )
}