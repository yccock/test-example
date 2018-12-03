package com.test.strategy.strategy;

import java.util.List;

/**
 * 根据搜索的jar文件解析
 */
public class SearchJarStragegy implements IStrategy {

    @Override
    public List<Class> getClassFromJar(String jar) {
        System.out.println("搜索解析");
        return null;
    }

}
