package com.test.pool.demo2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectionFactory extends BasePooledObjectFactory<Socket>{

    private InetSocketAddress address;

    public ConnectionFactory(String ip,int port){
        address = new InetSocketAddress(ip, port);
    }

    @Override
    public Socket create() throws Exception {
        Socket socket = new Socket();
        socket.connect(address);
        return socket;
    }

    @Override
    public PooledObject<Socket> wrap(Socket socket) {
        return new DefaultPooledObject<>(socket);
    }

    @Override
    public PooledObject<Socket> makeObject() throws Exception {
        return super.makeObject();
    }

    @Override
    public void destroyObject(PooledObject<Socket> p) throws Exception {
        if(p instanceof Socket){
            ((Socket)p).close();
        }
    }

    @Override
    public boolean validateObject(PooledObject<Socket> p) {
        if(p instanceof Socket){
            Socket socket = ((Socket)p);
            if(!socket.isConnected()){
                return false;
            }
            if(socket.isClosed()){
                return false;
            }
            return true;
        }
        return false;
    }
}
