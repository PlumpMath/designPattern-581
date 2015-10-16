package com.hfut.single;

/**
 * Created by dell on 2015/10/16.
 * 单例模式：对象创建型模式
 * 确保一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，
 * 这个类称为为单例类，它提供全局访问的方法。
 *
 * 单例模式的三个要点：
 * 1、类只能有一个实例;
 * 2、类必须自行创建这个实例;
 * 3、必须自行向整个系统提供这个实例
 *
 */
public class TaskManager {

    private static TaskManager tm = null;

    /**
     * 构造函数设置为私有
     */
    private TaskManager(){

    }

    public void displayProcess(){

    }

    public void displayServices(){

    }

    /**
     * static 方法
     * 实现单例，第一次调用getInstance()时创建唯一实例
     * @return
     */
    public static TaskManager getInstance(){
        if (tm == null) {
            tm = new TaskManager();
        }
        return tm;
    }
}
