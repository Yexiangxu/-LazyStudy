package luyao.wanandroid.enumdemo;

import org.junit.Test;

public class JavaTest {
    @Test
    public static void main(String[] args){
        int test=1;
        if (test==EnumDemo.FRIDAY){
            System.out.println("测试"+EnumDemo.FRIDAY);
        }
        DayEnum dayEnum=DayEnum.FRIDAY;
        switch (dayEnum){
            case MONDAY:
        }

    }
}
