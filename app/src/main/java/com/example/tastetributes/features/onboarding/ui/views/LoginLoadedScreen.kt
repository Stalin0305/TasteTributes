package com.example.tastetributes.features.onboarding.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.tastetributes.R
import com.example.tastetributes.customcomponents.CustomButton
import com.example.tastetributes.customcomponents.CustomTextField
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginIntent
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginViewState
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
            stringResource(id = R.string.hello),
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = AppDimens.dimen.twentyFour)
        )
        Text(
            stringResource(id = R.string.welcome_back),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = AppDimens.dimen.eight)
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.fortyEight))
        CustomTextField(
            label = stringResource(id = R.string.email),
            value = viewState.email,
            onValueChange = {
                onUserAction(LoginIntent.HandleEmailValueChange(it))
            },
            modifier = Modifier.padding(top = AppDimens.dimen.twentyFour),
            placeholderText = stringResource(id = R.string.enter_your_email),
            isError = viewState.isEmailInvalid,
            errorText = stringResource(id = R.string.error_text_email)
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.twentyFour))
        CustomTextField(
            label = stringResource(id = R.string.password),
            value = viewState.password,
            onValueChange = {
                onUserAction(LoginIntent.HandlePasswordChangeIntent(it))
            },
            placeholderText = stringResource(id = R.string.enter_your_password)
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.eight))
        Text(
            stringResource(id = R.string.forgot_password),
            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.tertiary),
            modifier = Modifier
                .padding(horizontal = AppDimens.dimen.eight, vertical = AppDimens.dimen.sixteen)
                .clickable {
                    //TODO
                }
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.fortyEight))
        CustomButton(
            onButtonClick = { onUserAction(LoginIntent.HandleSignInInButtonIntent) },
            modifier = Modifier.fillMaxWidth(),
            isEnabled = viewState.isSignInButtonEnabled
        ) {
            Text(
                text = stringResource(id = R.string.sign_in),
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
        Spacer(modifier = Modifier.height(AppDimens.dimen.fortyEight))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppDimens.dimen.fortyEight),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.or_sign_in_with),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center
            )

        }
        Spacer(modifier = Modifier.height(AppDimens.dimen.eighteen))
        Row(
            horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppDimens.dimen.twentyFour)
        ) {
            Box(modifier = Modifier.clickable { }) {
                Icon(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .clip(RoundedCornerShape(25f))
                        .padding(AppDimens.dimen.eight)
                )
            }
        }
        Spacer(modifier = Modifier.height(AppDimens.dimen.eight))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                stringResource(id = R.string.dont_have_an_account),
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.width(AppDimens.dimen.four))
            Text(
                stringResource(id = R.string.sign_up),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.clickable {
                    onUserAction(LoginIntent.HandleSignUpClicked)
                }
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