package com.hfut.factorypattern.singlefactory;

/**
 * Created by dell on 2015/10/19.
 */
public class ShapeFactory {

    public static Shape getShape(String type){
        Shape shape = null;
        if (type.equalsIgnoreCase("fangshape")) {
            shape = new FangShape();
        }else if (type.equalsIgnoreCase("yuanshape")){
            shape = new YuanShape();
        }else if (type.equalsIgnoreCase("sanjiaoshape")){
            shape = new SanJiaoShape();
        }
        return  shape;
    }
}
