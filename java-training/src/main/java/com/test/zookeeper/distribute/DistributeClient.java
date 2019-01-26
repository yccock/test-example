package com.test.zookeeper.distribute;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 从zookeeper获取节点信息
 */
public class DistributeClient {

    private ZooKeeper zkClient;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeClient client = new DistributeClient();
        //获取zookeeper节点集群
        client.getConnection();

        //注册监听
        client.getChildren();

        //业务处理
        client.business();
        
    }

    private void business() throws InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
    }

    private void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/servers", true);
        //存储节点主机名称
        List<Object> hosts = new ArrayList<>();
        for (String child : children) {
            byte[] data = zkClient.getData("servers" + child, false, null);
            hosts.add(new String(data));
        }
        System.out.println(hosts);
    }

    private void getConnection() throws IOException {
        String connectString = "127.0.0.1:2181";
        zkClient = new ZooKeeper(connectString, 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getChildren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
