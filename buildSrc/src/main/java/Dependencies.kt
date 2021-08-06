import org.gradle.api.artifacts.dsl.RepositoryHandler

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
    const val benmanesGradleVersionPlugin = "0.39.0"
    const val arouterPlugin = "1.0.2"
    const val arouter = "1.5.2"
    const val glide = "4.11.0"

    const val loggerVersion = "2.2.0"
    const val buglyVersion = "3.3.3"
    const val datastoreVersion="1.0.0-beta02"
    const val stethoVerison="1.6.0"
    const val multidex="2.0.1"
    const val brvah="3.0.4"
}

object PluginsDeps {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePluginVersion}"
    const val benmanesGradleVersionPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.benmanesGradleVersionPlugin}"//用来检查所有依赖最新版本
    val addRepos: (handler: RepositoryHandler) -> Unit = {//统一提取maven依赖
        it.flatDir { dirs("libs")  }//依赖aar需要设置，https://zhuanlan.zhihu.com/p/44371449
        it.google()
        it.gradlePluginPortal()//gradle-versions-plugin需要
        it.mavenCentral()//因JCenter仓库自2021.5.1关闭，谷歌推荐使用Maven Central仓库，并创建项目默认将jcenter()变成mavenCentral()
        it.maven { setUrl("https://jitpack.io") }//或 it.maven { url = URI("https://jitpack.io") }
    }
}

object KotlinDeps {
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val kotlinStdlib="org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"//java转kotlin"

}
object ArouterDeps {
    const val arouterRegisterPlugin = "com.alibaba:arouter-register:${Versions.arouterPlugin}"////这个插件是在 transform jar 的时候直接把路由表通过 asm 工具直接写到 sdk 的类里面，就不用启动的时候扫描 dex 了，用于支持第三方App加固时自动注册
    const val arouterApi =  "com.alibaba:arouter-api:${Versions.arouter}"
    const val arouterCompiler =  "com.alibaba:arouter-compiler:${Versions.arouter}"//所有使用了arouter的model需要添加，否则跳转报错
}
object GlideDeps {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}
object CommonDeps{
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val brvah = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.brvah}"
}
object DebugDeps {
    const val logger = "com.orhanobut:logger:${Versions.loggerVersion}"
    const val bugly = "com.tencent.bugly:crashreport:${Versions.buglyVersion}"
    const val stetho ="com.facebook.stetho:stetho:${Versions.stethoVerison}"

}

object DataStoreDeps {
      const val datastorePreferences = "androidx.datastore:datastore-preferences:${Versions.datastoreVersion}"
}
