package demo01;

import org.junit.Test;

import java.util.Arrays;

public class EnumDemo {
    public static final int RED = 1;
    public static final int GREEN = 1;
    public static final int BLUE = 1;
    public int color;

    @Test
    public void test1() {
        color = RED;
        color = 4; // 普通常量不能控制color的取值范围
    }

    public Color colorEnum;
    @Test
    public void test2 () {
        colorEnum = Color.RED;
        System.out.println(colorEnum);
        System.out.println(colorEnum.name());
        System.out.println(colorEnum.ordinal());
        System.out.println(colorEnum.toString());
        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));
    }

    @Test
    public void test3() {
        // 测试枚举实现接口
        String color = Color.RED.colorStr();
        System.out.println(color);
        System.out.println(Color.BLUE.colorStr());
        System.out.println(Color.BLUE.colorValue());

    }
}
