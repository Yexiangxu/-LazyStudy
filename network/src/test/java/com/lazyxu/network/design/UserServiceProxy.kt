package com.lazyxu.network.design

class UserServiceProxy : UserService {
    lateinit var userService: UserServiceImpl

    @JvmName("setUserService1")
    fun setUserService(userService: UserServiceImpl) {
        this.userService = userService
    }

    override fun add() {
        userService.add()
    }

    override fun delete() {
        userService.delete()
    }

    override fun update() {
        userService.update()
    }

    override fun query() {
        userService.query()
    }
}