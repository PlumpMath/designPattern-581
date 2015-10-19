package com.hfut.factorypattern.singlefactory;

/**
 * Created by dell on 2015/10/19.
 */
public class YuanShape extends Shape {

    @Override
    public void draw() {
        try {
            System.out.println("绘制圆形");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("UnSupportedShapeException");
        }
    }

    @Override
    public void erase() {
        System.out.println("擦除圆形");
    }
}
