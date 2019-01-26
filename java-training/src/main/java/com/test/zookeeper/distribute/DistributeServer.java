package com.test.zookeeper.distribute;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * 服务器节点动态上下线
 * 服务端注册信息到zookeeper
 */
public class DistributeServer {

    private ZooKeeper zkClient;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeServer server = new DistributeServer();
        //获取zoookeeper集群
        server.getConnection();

        //注册节点
        server.regist(args[0]);

        //业务处理
        server.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
    }

    private void regist(String hostname) throws KeeperException, InterruptedException {
        String path = zkClient.create("/servers/server", hostname.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname + " is online");
    }

    private void getConnection() throws IOException {
        String connectString = "127.0.0.1:2181";
        zkClient = new ZooKeeper(connectString, 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

}
