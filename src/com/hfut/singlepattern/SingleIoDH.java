package com.hfut.singlepattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 2015/10/17.
 */
public class SingleIoDH {

    private List serverList = null;

    private SingleIoDH(){
        serverList = new ArrayList();
    }

    public static class HolderClass{
        private final static SingleIoDH instance = new SingleIoDH();
    }

    public static SingleIoDH getIntance(){
        return HolderClass.instance;
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
