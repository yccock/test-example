package com.test;


import javax.xml.ws.Endpoint;

public class ServerStartup {

    public static String uri = "http://127.0.0.1:9000/webserviceDemo";

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        Endpoint.publish(uri, helloService);
        System.out.println("服务发布成功");
    }
}
