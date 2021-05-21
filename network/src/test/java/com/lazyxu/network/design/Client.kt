package com.lazyxu.network.design

import org.junit.Test

class Client {
    @Test
    fun main(){
        val userService:UserService=UserServiceImpl()
        userService.add()
    }
}