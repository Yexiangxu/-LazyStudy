object BuildConfig {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 101
    const val versionName = "1.0.1"
}

object Versions {
    const val kotlin_version = "1.5.10"
    const val gradle_plugin_version = "4.1.1"
    const val logger_version = "2.2.0"
    const val bugly_version = "3.3.3"
}

object PluginsDeps {
    const val gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle_plugin_version}"
}

object KotlinDeps {
    const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    const val kotlin_stdlib="org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"//java转kotlin"

}

object DebugDeps {
    const val logger = "com.orhanobut:logger:${Versions.logger_version}"
    const val bugly = "com.tencent.bugly:crashreport:${Versions.bugly_version}"

}