package com.hfut.factorypattern.singlefactory;

/**
 * Created by dell on 2015/10/17.
 * 抽象产品类
 *
 * 需要对产品进行重构，不能涉及一个包罗万象的产品类，需要根据实际情况设计一个产品层次结构
 * 将所有产品类公共的代码移至抽象产品类，并在抽象产品类中声明一些抽象方法，
 * 工不同的具体产品类来实现
 *
 */
abstract class BMW {
    public BMW(){

    }
}
