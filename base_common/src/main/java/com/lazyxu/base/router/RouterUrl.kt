package com.lazyxu.base.router

/**
 * User: xuyexiang
 * Date: 2019/06/11
 * Description:
 *    不同的module需要用不同的group（eg：不同的module用相同的group跳转失败）
 *    必须以 / 开头
 *
 * FIXME
 */
object RouterUrl {
    class User {
        companion object {
            private const val userGroup = "/user"
            const val LOGIN = "$userGroup/login"
            const val REGISTER = "$userGroup/register"
            const val FORGETPWD = "$userGroup/register"
        }
    }

    class Film {
        companion object {
            private const val filmGroup = "/main"
            const val FILM = "$filmGroup/film"
        }
    }
}
