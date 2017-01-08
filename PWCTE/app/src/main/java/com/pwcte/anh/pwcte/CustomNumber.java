package com.pwcte.anh.pwcte;

import java.math.BigDecimal;
import java.util.Random;

import static java.lang.Math.pow;

/**
 * Created by Anh Huynh on 1/7/2017.
 */

public class CustomNumber {


    public int getRandomNumber()
    {
        Random rand = new Random();
        int n;
        return n = rand.nextInt(100);

    }

    public int getSecondRandomNumber(int a)
    {
        Random rand = new Random();
        int n;
        return n = a + rand.nextInt(40) - 20;
    }


    public double getSmallNumber(int a, int order)
    {
        double b = ((double)a)/pow(10,order);
        return b;
    }
}
