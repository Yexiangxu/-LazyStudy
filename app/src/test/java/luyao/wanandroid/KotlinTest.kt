package luyao.wanandroid

import org.junit.Test
import java.util.*


class KotlinTest {
    @Test
    fun testEqual() {
        println(random(2000, 15))
    }

    fun random(totalNum: Int, count: Int): List<Int>? {
        // 创建一个长度的红包数组
        val redList: MutableList<Int> = ArrayList()
        //2. 进行随机分配
        val rand = Random()
        var leftMoney = totalNum // 剩余金额
        var leftCount = count // 剩余份数
        // 随机分配公式：1 + rand.nextInt(leftMoney / leftCount * 2);
        for (i in 0 until count - 1) {
            var money_ = 0
            money_ = if (leftMoney > 0) {
                if (leftMoney / leftCount * 2 < 1) {
                    leftMoney
                } else {
                    1 + rand.nextInt(leftMoney / leftCount * 2)
                }
            } else {
                0
            }
            redList.add(money_)
            if (money_ > 0) {
                leftMoney -= money_
                leftCount--
            }
        }
        // 把剩余的最后一个放到最后一个包里
        redList.add(leftMoney)
        return redList
    }

}