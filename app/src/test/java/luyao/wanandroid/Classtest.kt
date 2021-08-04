package luyao.wanandroid

import org.junit.Test

private const val LINE_TAGSIZE = 3//一行显示多少
@Test
fun main() {
    val numbers = listOf("one", "two", "three", "four", "five")
    val beginPosition = 3/ LINE_TAGSIZE * LINE_TAGSIZE
    val endPosition = if (numbers.size>=beginPosition+ LINE_TAGSIZE){
        beginPosition+ LINE_TAGSIZE-1
    }else{
        numbers.size-1
    }
    println(beginPosition)
    println(endPosition)
    println(numbers.slice(beginPosition..endPosition))
}

fun main1() {
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // 类扩展调用

}





