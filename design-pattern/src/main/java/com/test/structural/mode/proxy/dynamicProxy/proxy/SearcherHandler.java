package com.test.structural.mode.proxy.dynamicProxy.proxy;

import com.test.structural.mode.proxy.dynamicProxy.util.MonitorUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;


public class SearcherHandler<T> implements InvocationHandler {

    private T target;

    public SearcherHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(String.format("方法名:%s, 参数:%s", method.getName(), Arrays.asList(args)));
        //代理过程中插入监测方法,计算该方法耗时
        MonitorUtil.start();
        Object object = method.invoke(target, args);
        MonitorUtil.finish();
        return object;
    }
}
