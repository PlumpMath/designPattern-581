package com.hfut.factorypattern.singlefactory;

/**
 * Created by dell on 2015/10/17.
 * 简单工厂模式，定义一个工厂类，他可以根据参数的不同返回不同类的实例，
 * 被创建的实例通常都具有共同的父类，因为在简单工厂模式中用于创建实例的方法
 * 是静态方法,因此简单工厂模式又被称为静态工厂方法（Static Factory Method）模式
 * 属于类创建型模式
 */
public class SingleFactory {
    /**
     * 负责实现创建所有产品实例的内部逻辑
     * 可以被外界直接滴啊用，创建所需的产品对象
     * @param type
     * @return
     */
    public static BMW createBMW(int type){
        switch (type){
            case 320 :
                return new BMW320();
            case 523 :
                return new BMW523();
            default:
                break;
        }
        return null;
    }
}
