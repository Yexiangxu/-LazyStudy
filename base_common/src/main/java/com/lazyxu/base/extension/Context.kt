package com.lazyxu.base.extension

import android.content.Context
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