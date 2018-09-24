package com.test;

import com.test.ws.HelloService;
import com.test.ws.HelloServiceWs;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

public class MainTest {

    /**
     * apache cxf方式调用webservice
     * @throws Exception
     */
    public static void cxfCallWebservice()throws Exception{
        //这个是用cxf 客户端访问cxf部署的webservice服务
        //千万记住，访问cxf的webservice必须加上namespace ,否则通不过
        //现在又另外一个问题，传递过去的参数服务端接收不到
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:9000/webserviceDemo?wsdl");
        //url为调用webService的wsdl地址
        QName name=new QName("http://www.baidu.com/","sayHello");
        //namespace是命名空间，methodName是方法名
        String xmlStr = "aaa";
        //paramvalue为参数值
        Object[] objects=client.invoke(name,xmlStr);
        //调用web Service//输出调用结果
        System.out.println(objects[0].toString());
    }


    /**
     * 推荐
     * jdk编程方式调用webservice
     */
    public static void apiCallWebservice(){
        HelloServiceWs helloServiceWs = new HelloServiceWs();
        HelloService helloService = helloServiceWs.getHelloServiceImplPort();
        System.out.println( helloService.sayHello("aaa"));

    }
    public static void main(String[] args) throws Exception{
        MainTest.apiCallWebservice();
//        MainTest.cxfCallWebservice();
    }
}
