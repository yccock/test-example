package com.test.zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestZookeeper {

    ZooKeeper zooKeeper;
    String connectString = "127.0.0.1:2181";

    @Before
    public void connect() throws IOException {
        zooKeeper = new ZooKeeper(connectString, 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("-------start------");
                try {
                    List<String> children = zooKeeper.getChildren("/", true);
                    for (String child : children) {
                        System.out.println(child);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------end------");
            }
        });
    }

    /**
     * 创建节点
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String path = zooKeeper.create("/wdx", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println(path);
    }

    /**
     * 获取节点数据，并监听节点变化
     */
    @Test
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
    }

    /**
     * 节点是否存在
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void exist() throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists("/wdx", false);
        System.out.println(stat == null ? "not exist" : " exist");

    }

}
