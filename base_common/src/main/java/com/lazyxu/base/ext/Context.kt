package com.lazyxu.base.ext

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.lazyxu.base.base.BaseApplication


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = BaseApplication.INSTANCE.packageName + "_preferences",
    produceMigrations = { context ->
        listOf(SharedPreferencesMigration(context, BaseApplication.INSTANCE.packageName + "_preferences"))
    })

@Suppress("DEPRECATION")
@SuppressLint("MissingPermission")
fun Context.isConnectedNetwork(): Boolean = run {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    activeNetwork?.isConnectedOrConnecting == true
}