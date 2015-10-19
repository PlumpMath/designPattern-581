package com.hfut.singlepattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 2015/10/16.
 * 饿汉式单例模式实现
 * 优点：类被加载时就实例化，无须考虑多线程访问问题，
 * 可以确保实例的唯一性。从调用速度和反应时间角度来讲，
 * 由于单例对象一开始就得以创建，因此要优于懒汉式单例
 * 缺点：无论系统在运行时是否需要使用该单例对象，
 * 由于在类加载时该对象就需要创建，
 * 因此从资源利用效率角度来讲，饿汉式单例不及懒汉式单例，
 * 而且在系统加载时由于需要创建饿汉式单例对象，加载时间可能会比较长
 */
public class EagrSingleLeton {
    //在定义静态变量的时候实例化单例类，
    //因此在类加载的时候就已经创建了单例对象
    private static final EagrSingleLeton instance = new EagrSingleLeton();

    private List serverList = null;

    private EagrSingleLeton(){
        serverList = new ArrayList();
    }

    public static EagrSingleLeton getLoadBalancer() {
        return instance;
    }

    //增加服务器
    public void addService(String server){
        serverList.add(server);
    }
    //删除服务器
    public void removeService(String server){
        serverList.remove(server);
    }
    //使用Random类随机获取服务器
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String)serverList.get(i);
    }
}
