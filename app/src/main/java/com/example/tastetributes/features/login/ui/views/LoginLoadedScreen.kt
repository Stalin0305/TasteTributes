package com.example.tastetributes.features.login.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastetributes.R
import com.example.tastetributes.customcomponents.CustomButton
import com.example.tastetributes.customcomponents.CustomTextField
import com.example.tastetributes.features.login.ui.viewstates.LoginIntent
import com.example.tastetributes.features.login.ui.viewstates.LoginViewState
import com.example.tastetributes.ui.theme.AppDimens
import com.example.tastetributes.ui.theme.TasteTributesTheme
import com.example.tastetributes.ui.theme.rememberWindowSizeClass

@Composable
fun LoginLoadedScreen(
    viewState: LoginViewState.LoadedData,
    onUserAction: (LoginIntent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimens.dimen.twentyFour), verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(AppDimens.dimen.twentyFour))
        Text(
            "Hello,",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = AppDimens.dimen.twentyFour)
        )
        Text(
            "Welcome back!",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = AppDimens.dimen.eight)
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.fortyEight))
        CustomTextField(
            label = "Email",
            value = viewState.email,
            onValueChange = {
                onUserAction(LoginIntent.HandleEmailValueChange(it))
            },
            modifier = Modifier.padding(top = AppDimens.dimen.twentyFour),
            placeholderText = "Enter your email"
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.twentyFour))
        CustomTextField(
            label = "Password",
            value = viewState.password,
            onValueChange = {},
            placeholderText = "Enter your password"
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.eight))
        Text(
            "Forgot password?",
            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.tertiary),
            modifier = Modifier
                .padding(horizontal = AppDimens.dimen.eight, vertical = AppDimens.dimen.sixteen)
                .clickable {
                    //TODO
                }
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.fortyEight))
        CustomButton(onButtonClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Sign in",
                textAlign = TextAlign.Center,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.width(AppDimens.dimen.sixteen))
            Icon(
                painter = painterResource(id = R.drawable.arrow_forward),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(vertical = AppDimens.dimen.four),
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginLoadedPreview() {
    TasteTributesTheme(windowSizeClass = rememberWindowSizeClass()) {
        LoginLoadedScreen(
            viewState = LoginViewState.LoadedData(email = "", password = ""),
            onUserAction = {})
    }
}