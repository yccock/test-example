package com.test.commons_pool2.demo2;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.net.Socket;

public class TestMain {

    public static void main(String[] args) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(16);
        config.setMaxWaitMillis(30000);
        ConnectionPoolFactory poolFactory = new ConnectionPoolFactory(config, "127.0.0.1", 12345);
        Socket socket = null ;
        try{
            socket = poolFactory.getConnection();
            System.out.println(socket);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(socket != null){
                poolFactory.releaseConnection(socket);
            }
        }

    }
}
