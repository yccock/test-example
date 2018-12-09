package com.test.structural.mode.proxy.dynamicProxy;

import com.test.structural.mode.proxy.dynamicProxy.proxy.SearcherHandler;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        ISearcher searcher = new SearcherImpl();
        //创建一个与代理对象相关联的InvocationHandler
        SearcherHandler<ISearcher> searcherHandler = new SearcherHandler<>(searcher);
        ISearcher searchProxy = (ISearcher) Proxy.newProxyInstance(ISearcher.class.getClassLoader(), new Class[]{ISearcher.class}, searcherHandler);
        searchProxy.doSearch("test", "葵花宝典");
    }
}
