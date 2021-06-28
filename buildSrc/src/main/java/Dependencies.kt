object BuildConfig {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 101
    const val versionName = "1.0.1"
}

object Versions {
    const val kotlinVersion = "1.5.10"
    const val gradlePluginVersion = "4.1.1"
    const val loggerVersion = "2.2.0"
    const val buglyVersion = "3.3.3"
    const val datastoreVersion="1.0.0-beta02"
    const val stethoVerison="1.6.0"
}

object PluginsDeps {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePluginVersion}"
}

object KotlinDeps {
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val kotlinStdlib="org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"//java转kotlin"

}

object DebugDeps {
    const val logger = "com.orhanobut:logger:${Versions.loggerVersion}"
    const val bugly = "com.tencent.bugly:crashreport:${Versions.buglyVersion}"
    const val stetho ="com.facebook.stetho:stetho:${Versions.stethoVerison}"

}

object DataStoreDeps {
      const val datastorePreferences = "androidx.datastore:datastore-preferences:${Versions.datastoreVersion}"
}