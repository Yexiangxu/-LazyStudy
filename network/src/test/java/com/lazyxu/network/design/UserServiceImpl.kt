package com.lazyxu.network.design

class UserServiceImpl :UserService {
    override fun add() {
        println("增加了一个用户")
    }

    override fun delete() {
        println("删除了一个用户")
    }

    override fun update() {
        println("修改了一个用户")
    }

    override fun query() {
        println("查询了一个用户")
    }
}