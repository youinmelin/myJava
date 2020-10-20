package com.lin;

public class EqualsDemo {
    public static void main(String[] args) {
        Integer int01 = 1;
        Integer int02 = 1;
        System.out.println(int01 == int02);
        System.out.println(int01.equals(int02));
        Integer int03 = Integer.valueOf(1);
        System.out.println(int01 == int03);
        System.out.println(int01.equals(int03));

    }


}
