package edu.prahlad.java.tips;

import java.util.Arrays;

/**
 * Enum - Enumeration class
 * Enum can be created as independent class
 */

enum Season{
    Winter(1), SPRING(2), SUMMER(3), FALL(4);

    private int value;
    private Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class EnumRunner {

    public static void main(String[] args) {
        Season season = Season.FALL;

        Season season1 = Season.valueOf("Winter");//Case sensitive
        System.out.println(season1);
        System.out.println(season1.name());
        System.out.println(season1.ordinal());
        System.out.println(season1.getValue());

        System.out.println(Arrays.toString(Season.values()));
    }
}
