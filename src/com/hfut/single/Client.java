package com.hfut.single;

/**
 * Created by dell on 2015/10/16.
 */
public class Client {
    public static void main(String[] args) {
        LoadBalancer balancer1 = LoadBalancer.getLoadBalancer();
        LoadBalancer balancer2 = LoadBalancer.getLoadBalancer();
        LoadBalancer balancer3 = LoadBalancer.getLoadBalancer();
        LoadBalancer balancer4 = LoadBalancer.getLoadBalancer();

        if (balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4){
            System.out.println("服务器负载均衡器具有唯一性");
        }

        balancer1.addService("server1");
        balancer1.addService("server2");
        balancer1.addService("server3");

        for (int i = 0; i < 10; i++) {
            String server = balancer1.getServer();
            System.out.println("分发请求服务器：" + server);
        }

    }
}
