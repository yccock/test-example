package com.test.strategy;

import com.test.strategy.strategy.IStrategy;

import java.util.List;

/**
 * 环境(Context)角色：持有一个Strategy的引用
 */
public class Context {

    IStrategy iStrategy;

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public List<Class> parseJar(String jar){
        return iStrategy.getClassFromJar(jar);
    }
}
