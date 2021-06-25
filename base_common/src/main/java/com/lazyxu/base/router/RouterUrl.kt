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
    const val PATH = "path"



    class User {
        companion object {
            const val USERGROUP = "/user/"
            const val LOGIN = USERGROUP + "login"
            const val REGISTER = USERGROUP + "register"
            const val FORGETPWD = "/lazytest/register"
        }
    }
    class Film {
        companion object {
            const val FILMGROUP = "/main/"
            const val FILM = FILMGROUP + "film"
        }
    }
}
