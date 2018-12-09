package com.test.structural.mode.proxy.dynamicProxy;

/**
 * 抽象查询类，充当抽象主题角色
 */
public interface ISearcher {

    String doSearch(String userId, String keyword);
}
