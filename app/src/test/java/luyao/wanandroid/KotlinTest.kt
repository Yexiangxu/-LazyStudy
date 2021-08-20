package luyao.wanandroid

import luyao.wanandroid.enumdemo.Color1
import luyao.wanandroid.enumdemo.Color2
import org.junit.Test


class KotlinTest {


    fun functionA(funParam: (Int) -> String): String {
        return funParam(1)
    }




}

@Test
fun main() {
    colorType(Color1.BLUE)
}
fun colorType(colortype:Color1){
    when(colortype){
        Color1.BLUE-> println("蓝色代表忧郁")
        Color1.RED->println("蓝色代表忧郁")
        Color1.GREEN->println("绿色代表草原")
    }
}


