package com.example.tastetributes.utils

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.clickable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HandlePermissions(
    permissionList: List<String>,
) {
    val multiplePermissionsState = rememberMultiplePermissionsState(permissions = permissionList)
    val context = LocalContext.current

    val lifeCycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifeCycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    multiplePermissionsState.launchMultiplePermissionRequest()
                }

                else -> {

                }
            }
        }
        lifeCycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifeCycleOwner.lifecycle.removeObserver(observer)
        }
    }

    multiplePermissionsState.permissions.forEach { permissionState ->
        val permissionText = getPermissionText(permissionState.permission)
        if (permissionState.status.isGranted) {

        } else if (permissionState.status.shouldShowRationale) {
            AlertDialog(
                onDismissRequest = {},
                confirmButton = { Text(
                    modifier = Modifier.clickable { permissionState.launchPermissionRequest() },
                    text = "Grant permission"
                ) },
                text = { Text(text = permissionText.permissionRationaleText) })
        } else {
            AlertDialog(
                onDismissRequest = {  },
                confirmButton = { Text(modifier = Modifier.clickable {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        val uri = Uri.fromParts("package", context.packageName, null)
                        data = uri
                    }
                    context.startActivity(intent)
                }, text = "Settings") },
                text = { Text(text = permissionText.permissionRequiredText) })
        }
    }

}

fun getPermissionText(permission: String): PermissionText {
    return when (permission) {
        android.Manifest.permission.CAMERA -> PermissionText(
            permissionGranted = "Permission granted for Camera",
            permissionRationaleText = "This app needs Camera permission to function. Please provide the Camera permission.",
            permissionRequiredText = "Please provide the Camera permission by going to settings and granting the permission"
        )

        android.Manifest.permission.ACCESS_COARSE_LOCATION -> PermissionText(
            permissionGranted = "Permission granted for Location",
            permissionRationaleText = "This app needs Location permission to function. Please provide the Location permission.",
            permissionRequiredText = "Please provide the Location permission by going to settings and granting the permission"
        )

        else -> {
            PermissionText()
        }
    }
}

data class PermissionText(
    val permissionGranted: String = "",
    val permissionRationaleText: String = "",
    val permissionRequiredText: String = "",
)