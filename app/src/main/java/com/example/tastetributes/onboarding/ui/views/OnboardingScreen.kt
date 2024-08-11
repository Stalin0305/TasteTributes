package com.example.tastetributes.onboarding.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OnBoardingScreen(
    paddingValues: PaddingValues,
) {
    Column(modifier = Modifier.padding(paddingValues.calculateBottomPadding())) {
        Text("Onboarding screen")
    }
}