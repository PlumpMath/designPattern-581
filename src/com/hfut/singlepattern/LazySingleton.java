package com.hfut.singlepattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 2015/10/17.
 * 懒汉式单例模式，
 * （延迟加载技术：Lazy Load）
 * 在第一次调用getIntance()方法时实例化，在类加载时并不自行实例化，
 *
 *  懒汉式单例类在第一次使用时创建，无须一直占用系统资源，实现了延迟加载，
 *  但是必须处理好多个线程同时访问的问题，特别是当单例类作为资源控制器，
 *  在实例化时必然涉及资源初始化，而资源初始化很有可能耗费大量时间，
 *  这意味着出现多线程同时首次引用此类的机率变得较大，
 *  需要通过双重检查锁定等机制进行控制，这将导致系统性能受到一定影响
 */
public class LazySingleton {
    volatile private static LazySingleton instance = null;
    private List serverList = null;

    private LazySingleton(){
        serverList = new ArrayList();
    }
    // 增加了关键字synchronized进行线程锁，以处理多个线程同时访问的问题
    // 但是，
    // 每次调用getInstance()时都需要进行线程锁定判断，在多线程高并发访问环境中，将会导致系统性能大大降低
    synchronized public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    //对“instance = new LazySingleton();”进行锁定
    //该实现方法方法不够完善，
    //线程A进入synchronized锁定的代码中执行实例创建代码，
    //线程B处于排队等待状态，必须等待线程A执行完毕后才可以进入synchronized锁定代码。
    //但当A执行完毕时，线程B并不知道实例已经创建，将继续创建新的实例，导致产生多个单例对象，
    //违背单例模式的设计思想，因此需要进行进一步改进
    public static LazySingleton getInstance1(){
        if (instance == null) {
            synchronized (LazySingleton.class) {
                instance = new LazySingleton();
            }
        }
        return instance;
    }

    /**
     * 双重检查锁定(Double-Check Locking):
     * 在synchronized中再进行一次(instance == null)判断
     *
     * @return
     */
    public static LazySingleton getInstance2(){
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
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