package com.example.tastetributes.customcomponents

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tastetributes.ui.theme.TasteTributesTheme
import com.example.tastetributes.ui.theme.primaryLight
import com.example.tastetributes.ui.theme.rememberWindowSizeClass

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    isEnabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onButtonClick,
        modifier = modifier,
        shape = RoundedCornerShape(25),
        colors = ButtonDefaults.buttonColors(
            containerColor = primaryLight
        ),
        enabled = isEnabled,
        content = content
    )
}

@Preview
@Composable
fun CustomButtonPreview() {
    val windowSizeClass = rememberWindowSizeClass()
    TasteTributesTheme(windowSizeClass = windowSizeClass) {
        CustomButton(onButtonClick = {}) {
            Text("Start Cooking")
        }
    }
}