package com.example.tastetributes.features.onboarding.ui.views

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.tastetributes.R
import com.example.tastetributes.customcomponents.CustomButton
import com.example.tastetributes.customcomponents.CustomTextField
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.RegistrationIntent
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.RegistrationViewState
import com.example.tastetributes.ui.theme.AppDimens
import com.example.tastetributes.ui.theme.TasteTributesTheme
import com.example.tastetributes.ui.theme.rememberWindowSizeClass

@Composable
fun RegistrationLoadedScreen(
    viewState: RegistrationViewState.DataLoaded,
    onUserAction: (RegistrationIntent) -> Unit,
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    LaunchedEffect(key1 = viewState.shouldShowToast) {
        if (viewState.shouldShowToast) {
            Toast.makeText(context, viewState.toastMessage, Toast.LENGTH_LONG).show()
            onUserAction(RegistrationIntent.DismissToast)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppDimens.dimen.twentyFour)
            .scrollable(scrollState, orientation = Orientation.Vertical),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.height(AppDimens.dimen.thirtyTwo))
        Text(
            stringResource(id = R.string.create_an_account),
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
        )
        Text(
            stringResource(id = R.string.create_an_account_desc),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = AppDimens.dimen.eight)
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.twentyFour))
        CustomTextField(
            label = stringResource(id = R.string.name),
            value = viewState.name,
            onValueChange = {
                onUserAction(RegistrationIntent.HandleNameChangedIntent(it))
            },
            modifier = Modifier.padding(top = AppDimens.dimen.twentyFour),
            placeholderText = stringResource(id = R.string.enter_your_name)
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.twentyFour))
        CustomTextField(
            label = stringResource(id = R.string.email),
            value = viewState.email,
            onValueChange = {
                onUserAction(RegistrationIntent.HandleEmailChangedIntent(it))
            },
            placeholderText = stringResource(id = R.string.enter_your_email),
            isError = viewState.isEmailInvalid,
            errorText = stringResource(id = R.string.error_text_email)
        )
        CustomTextField(
            label = stringResource(id = R.string.password),
            value = viewState.password,
            onValueChange = {
                onUserAction(RegistrationIntent.HandlePasswordChangedIntent(it))
            },
            modifier = Modifier.padding(top = AppDimens.dimen.twentyFour),
            placeholderText = stringResource(id = R.string.enter_your_password),
            isError = viewState.isPasswordInvalid,
            isPasswordTextField = true,
            errorText = stringResource(id = R.string.error_text_password)
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.twentyFour))
        CustomTextField(
            label = stringResource(id = R.string.confirm_password),
            value = viewState.confirmPassword,
            onValueChange = {
                onUserAction(RegistrationIntent.HandleConfirmPasswordChangedIntent(it))
            },
            isPasswordTextField = true,
            placeholderText = stringResource(id = R.string.retype_password),
            isError = viewState.isConfirmPasswordInvalid,
            errorText = stringResource(id = R.string.error_text_confirm_password)
        )
        Spacer(modifier = Modifier.height(AppDimens.dimen.eight))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = viewState.isTermsAccepted,
                onCheckedChange = {
                    onUserAction(RegistrationIntent.HandleTermsConditionCheckBoxIntent(it))
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.secondary,
                    uncheckedColor = MaterialTheme.colorScheme.secondary
                )
            )
            Text(
                text = stringResource(id = R.string.terms_and_conditions),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Spacer(modifier = Modifier.width(AppDimens.dimen.eight))
        CustomButton(
            onButtonClick = { onUserAction(RegistrationIntent.HandleRegistrationButtonClickedIntent) },
            modifier = Modifier.fillMaxWidth(),
            isEnabled = viewState.isSignUpButtonEnabled,
        ) {
            Text(
                text = stringResource(id = R.string.sign_up),
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
                .fillMaxWidth(),
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
                stringResource(id = R.string.already_a_member),
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.width(AppDimens.dimen.four))
            Text(
                stringResource(id = R.string.sign_in),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.clickable {
                    onUserAction(RegistrationIntent.HandleSignInButtonClickedIntent)
                }
            )
        }

    }


}

@Composable
@Preview(showBackground = true)
fun RegistrationLoadedPreview() {
    TasteTributesTheme(windowSizeClass = rememberWindowSizeClass()) {
        RegistrationLoadedScreen(viewState = RegistrationViewState.DataLoaded(), onUserAction = {})
    }
}