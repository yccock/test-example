package com.test.javassist.demo2;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

public class JavassistAop {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();
        //设置父类，ProxyFactory将会动态生成一个类，继承该父类
        proxyFactory.setSuperclass(Hello.class);
        proxyFactory.setFilter(new MethodFilter() {
            @Override
            public boolean isHandled(Method method) {
                return method.getName().equals("print");
            }
        });
        proxyFactory.setHandler(new MethodHandler() {
            @Override
            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
                long start = System.currentTimeMillis();
                Object object = proceed.invoke(self, args);
                System.out.println("====" + (System.currentTimeMillis() - start));
                return object;
            }
        });
        Class<?> aClass = proxyFactory.createClass();
        Hello hello = (Hello) aClass.newInstance();
        hello.print();
    }
}
