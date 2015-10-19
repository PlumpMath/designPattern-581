package com.hfut.singlepattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 2015/10/16.
 * 单例模式实现负载均衡器：
 * 将并发访问和数据流量分发到服务器集群中的多台设备上进行并发处理，提高系统的整体
 * 处理能力，缩短访问时间
 * 由于集群中的服务器需要动态删减，切客户端需要统一分发，因此需要确保负载均衡器的唯一
 * 性，只能有一个负载均衡器来负责服务器的管理和请求的分发，
 * 否则将会带来服务器状态的不一致以及请求分配冲突等问题。
 *
 * 注意：这种实现方式依然会出现客户端提交请求时出现请求分发失败，存在多个
 * 负载均衡器对象，导致分发时目标服务器不一致，产生冲突。
 * 改进的实现方法有：
 * 饿汉式单例 ===>>EagrSingleLeton
 * 懒汉式单例 ===>>LazySingleton
 *
 */
public class LoadBalancer {
    private static LoadBalancer instance = null;
    private List serverList = null;

    private LoadBalancer(){
        serverList = new ArrayList();
    }

    public static LoadBalancer getLoadBalancer() {
        if (instance == null) {
            instance = new LoadBalancer();
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
