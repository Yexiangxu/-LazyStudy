
object BuildConfig {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 101
    const val versionName = "1.0.1"
}

object Versions{
    const val kotlin_version = "1.5.10"
    const val gradle_plugin_version = "4.2.1"
}

object PluginsDeps {
    var gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle_plugin_version}"
}
object KotlinDeps {
    var kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
}