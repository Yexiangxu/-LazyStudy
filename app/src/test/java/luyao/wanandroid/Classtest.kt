package luyao.wanandroid

import kotlinx.coroutines.*
import org.junit.Test
import java.lang.Thread.sleep
import kotlin.system.measureTimeMillis

class Classtest {


    @Test
    fun testscope() = runBlocking {
//        val periodStrategy = PeriodStrategy()
//        periodStrategy.start()

//        val scope = CoroutineScope(Job() + Dispatchers.Main)
//        println("I'm working in thread 1${Thread.currentThread().name}")
//        val job = scope.launch {
//            println("I'm working in thread 1${Thread.currentThread().name}")
//            // 新的协程会将 CoroutineScope 作为父级
//
//        }


    }

    @Test
    fun main1() = runBlocking {
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // 延迟一段时间
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()//取消协程，一段协程代码必须协作才能被取消
        println("main: Now I can quit.")
    }

    @Test
    fun main() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            repeat(20) { test ->// 一个执行计算的循环，只是为了占用 CPU
                delay(5000)
                // 每秒打印消息两次
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // 等待一段时间
        println("main: I'm tired of waiting!")
//        job.cancelAndJoin() // 取消一个作业并且等待它结束
        println("main: Now I can quit.")
    }

    @Test
    fun main222() = runBlocking { // this: CoroutineScope
        val time = System.currentTimeMillis()
        launch {
            delay(8000L)
            println("【${Thread.currentThread().name}】在 runBlocking 里的任务")

        }

        coroutineScope { // 创建一个协程作用域
            launch(Dispatchers.Default) {
                delay(5000L)
                println("Task from nested launch ${System.currentTimeMillis() - time}")
            }
            delay(1000L)
            println("Task from coroutine scope ${System.currentTimeMillis() - time}") // 这一行会在内嵌 launch 之前输出
        }

        println("Coroutine scope is over ${System.currentTimeMillis() - time}") // 这一行在内嵌 launch 执行完毕后才输出
    }


    @Test
    fun main333() = runBlocking {
        repeat(100_000) { // 启动大量的协程
            launch {
                delay(5000L)
                print(".")
            }
        }
    }

    @Test
    fun main555() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // 可以被取消的计算循环
                // 每秒打印消息两次
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // 等待一段时间
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // 取消该作业并等待它结束
        println("main: Now I can quit.")
    }

    @Test
    fun main666() {
        val time = measureTimeMillis {
            val one = doSomethingUsefulOne()
            val two = doSomethingUsefulTwo()
            println("The answer is ${one + two}")
        }
        println("Completed in $time ms")
    }

    fun doSomethingUsefulOne(): Int {
        sleep(2000L) // 假设我们在这里做了些有用的事
        return 13
    }

    fun doSomethingUsefulTwo(): Int {
        sleep(1000L) // 假设我们在这里也做了一些有用的事
        return 29
    }

    @Test
    fun main11() = runBlocking {
        withTimeout(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(2000)
        println("Completed in")
    }

    @Test
    fun main12() = runBlocking {
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
        println("main: I'm tired of waiting!")
        job.cancel() // 取消该作业
        job.join() // 等待作业执行结束
        delay(2000L) // 延迟一段时间

        println("main: Now I can quit.")
    }

    @Test
    fun main51() = runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                println("job: I'm running finally")
            }
        }
        delay(1300L) // 延迟一段时间
        println("main: I'm tired of waiting!")
        job.cancel() // 取消该作业
        job.join() // 等待作业执行结束
        delay(2000)
        println("main: Now I can quit.")
    }

    @Test
    fun main52() = runBlocking<Unit> {
        launch(Dispatchers.Unconfined) { // 非受限的——将和主线程一起工作
            println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
            delay(500)
            println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
        }
        launch { // 父协程的上下文，主 runBlocking 协程
            println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
            delay(1000)
            println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
        }
    }

    fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

    @Test
    fun main53() = runBlocking<Unit> {
        val time = System.currentTimeMillis()
        val a = async {
            delay(1000)
            log("time=${System.currentTimeMillis() - time},I'm computing a piece of the answer")
            6
        }
        val b = async {
            delay(1000)
            log("time=${System.currentTimeMillis() - time},I'm computing another piece of the answer")
            7
        }
        log("time=${System.currentTimeMillis() - time},The answer is ${a.await() * b.await()}")
    }

    @Test
    fun main111() {
        val stringPlus: (String, String) -> String = String::plus
        val intPlus: Int.(Int) -> Int = Int::plus

        println(stringPlus.invoke("<-", "->"))
        println(stringPlus("Hello, ", "world!"))

        println(intPlus.invoke(1, 1))
        println(intPlus(1, 2))
        println(2.intPlus(3)) // 类扩展调用
    }

    @Test
    fun testrun() = runBlocking {

        val job = launch {
            launch {
                println("嵌套的顶层协程开始工作")
                delay(1000)
                println("嵌套的顶层协程结束工作")
            }
            launch {
                println("嵌套的子协程开始工作")
                delay(1000)
                println("嵌套的子协程结束工作")
            }
        }
        delay(500)
        job.cancel()
        delay(2000)

        println("Main函数执行完毕")

    }
}


