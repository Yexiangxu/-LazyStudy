package com.lazyxu.base.ext

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.lazyxu.base.base.BaseApplication

val dataStore: DataStore<Preferences> = BaseApplication.INSTANCE.dataStore