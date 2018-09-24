package com.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * 生成客户端代码
 *
* 1.在target/class目录下新建文件夹wsdl、src,并进入target/class目录
* 2.wsgen -cp . -r ./wsdl -s ./ -d ./ -wsdl com.wdx.test.HelloServiceImpl
* 3.wsimport -s ./src -p com.test.ws http://127.0.0.1:9000/webserviceDemo?wsdl
 */

//指定webservice所实现的接口以及服务名称
@WebService(serviceName = "HelloServiceWs")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloServiceImpl implements HelloService{

    @WebMethod
    @WebResult(name = "returnSayHello")
    public String sayHello(@WebParam(name="keyword") String keyword) {
        System.out.println("response:" + keyword);
        return "response:" + keyword;
    }

    @WebMethod(exclude=true)//当前方法不被发布出去
    public String sayHello2(String name){
        return "hello " + name;
    }
}
