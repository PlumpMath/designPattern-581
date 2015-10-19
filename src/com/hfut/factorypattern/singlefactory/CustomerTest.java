package com.hfut.factorypattern.singlefactory;

/**
 * Created by dell on 2015/10/18.
 */
public class CustomerTest {
    public static void main(String[] args) {
        BMW bmw320 = SingleFactory.createBMW(320);
        BMW bmw523 = SingleFactory.createBMW(523);


    }
}
