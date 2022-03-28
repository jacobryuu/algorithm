package com.algorithm;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Sample {

    public static void main(String[] args) {
        float num = 29.50f;

        BigDecimal bd = new BigDecimal(num);

        BigDecimal bd1 = bd.setScale(2, RoundingMode.HALF_UP);
        System.out.println(bd1);
        System.out.println(bd1.floatValue());
    }
}
