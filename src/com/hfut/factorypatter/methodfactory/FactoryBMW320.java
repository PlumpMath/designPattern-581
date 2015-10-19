package com.hfut.factorypatter.methodfactory;

/**
 * Created by dell on 2015/10/18.
 */
public class FactoryBMW320 implements FactoryBMW {

    @Override
    public BMW320 createBMW() {
        return new BMW320();
    }
}
