package com.example.tastetributes.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object NetworkHelper {
    fun isConnectedToNetwork(context: Context): Boolean {
        val connectivityManager: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val isConnectedToMobileData =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                ?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false

        val isConnectedToWifi =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                ?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false

        return isConnectedToWifi || isConnectedToMobileData
    }
}