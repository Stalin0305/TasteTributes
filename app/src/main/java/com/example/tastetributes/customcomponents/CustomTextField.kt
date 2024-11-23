package com.example.tastetributes.customcomponents

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.tastetributes.R
import com.example.tastetributes.ui.theme.AppDimens
import com.example.tastetributes.utils.Constants.EMPTY_STRING

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholderText: String,
    isError: Boolean = false,
    errorText: String = EMPTY_STRING,
    isPasswordTextField: Boolean = false,
    onValueChange: (String) -> Unit,
) {
    val shouldShowError = isError && value.isNotBlank()
    var isVisible by  remember { mutableStateOf(false) }
    Column(
        modifier = modifier
    ) {
        if (shouldShowError) {
            Text(
                text = errorText,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.error
            )
        } else {
            Text(label, style = MaterialTheme.typography.labelLarge)
        }
        Spacer(Modifier.height(AppDimens.dimen.eight))
        TextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            placeholder = {
                Text(placeholderText)
            },
            trailingIcon = {
                if (isPasswordTextField) {
                    IconButton(onClick = { isVisible = !isVisible}) {
                        Icon(
                            painter = if (isVisible.not()) painterResource(id = R.drawable.visibility_off) else painterResource(
                                id = R.drawable.visibility_icon
                            ), contentDescription = null
                        )
                    }
                }
            },
            isError = shouldShowError,
            visualTransformation = if (isVisible.not() && isPasswordTextField) PasswordVisualTransformation() else VisualTransformation.None,
            shape = RoundedCornerShape(0.8f),
            modifier = Modifier
                .clip(RoundedCornerShape(0.35f))
                .border(
                    width = if (shouldShowError) AppDimens.dimen.four else AppDimens.dimen.one,
                    shape = RoundedCornerShape(AppDimens.dimen.eight),
                    color = if (shouldShowError) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.primaryContainer
                )
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorCursorColor = MaterialTheme.colorScheme.error,
                errorIndicatorColor = MaterialTheme.colorScheme.onError
            ),
        )
    }

}