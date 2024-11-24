package com.example.tastetributes.features.onboarding.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.tastetributes.R
import com.example.tastetributes.customcomponents.CustomButton
import com.example.tastetributes.navigation.NavigationCommand
import com.example.tastetributes.navigation.NavigationManager
import com.example.tastetributes.ui.theme.AppDimens
import com.example.tastetributes.ui.theme.TasteTributesTheme
import com.example.tastetributes.ui.theme.rememberWindowSizeClass

@Composable
fun OnBoardingScreen(
    paddingValues: PaddingValues,
    navigationManager: NavigationManager
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .padding(paddingValues.calculateBottomPadding())
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(AppDimens.dimen.fortyEight)
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(AppDimens.dimen.fortyEight))
                Icon(
                    painter = painterResource(id = R.drawable.hat_icon),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(0.3f),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.height(AppDimens.dimen.sixteen))
                Text(
                    text = stringResource(id = R.string.taste_tributes),
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, color = Color.White)
                )
            }
            Column(
                modifier = Modifier.align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.get_cooking),
                    style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.fillMaxWidth(0.6f),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(AppDimens.dimen.twenty))
                Text(
                    text = stringResource(id = R.string.onboarding_subtitle),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(AppDimens.dimen.fortyEight))
                CustomButton(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    onButtonClick = {
                        navigationManager.navigateTo(NavigationCommand.Login)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.onboarding_button_text),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(AppDimens.dimen.eight))
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward_regular),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(vertical = AppDimens.dimen.four),
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(AppDimens.dimen.thirtyTwo))
            }
        }
    }
}

//@Preview
//@Composable
//fun OnboardingScreenPreview() {
//    TasteTributesTheme(windowSizeClass = rememberWindowSizeClass()) {
//        OnBoardingScreen(paddingValues = PaddingValues(), NavigationManager())
//    }
//}