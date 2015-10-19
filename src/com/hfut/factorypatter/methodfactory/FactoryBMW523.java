package com.hfut.factorypatter.methodfactory;

/**
 * Created by dell on 2015/10/18.
 */
public class FactoryBMW523 implements FactoryBMW {
    @Override
    public BMW523 createBMW() {
        return new BMW523();
    }
}
