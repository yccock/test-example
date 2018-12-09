package com.test.structural.mode.proxy.staticProxy.service;

/**
 * 具体查询类，充当真实主题角色，它实现查询功能
 */
public class RealSearcher implements ISearcher {
    @Override
    public String doSearch(String userId, String keyword) {
        System.out.println(String.format("用户%s使用关键词%s查询商务信息", userId, keyword));
        return "返回具体内容";
    }
}
