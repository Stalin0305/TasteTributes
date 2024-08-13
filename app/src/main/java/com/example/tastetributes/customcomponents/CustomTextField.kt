package com.example.tastetributes.customcomponents

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.tastetributes.ui.theme.AppDimens

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(label, style = MaterialTheme.typography.labelLarge)
        Spacer(Modifier.height(AppDimens.dimen.eight))
        TextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            placeholder = {
                Text(placeholderText)
            },
            shape = RoundedCornerShape(0.8f),
            modifier = Modifier
                .clip(RoundedCornerShape(0.35f))
                .border(
                    width = AppDimens.dimen.one,
                    shape = RoundedCornerShape(AppDimens.dimen.eight),
                    color = MaterialTheme.colorScheme.primaryContainer
                ).fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )
    }

}