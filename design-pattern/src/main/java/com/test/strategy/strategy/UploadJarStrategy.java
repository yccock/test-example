package com.test.strategy.strategy;

import java.util.List;

/**
 * 根据上传jar文件解析
 */
public class UploadJarStrategy implements IStrategy {

    @Override
    public List<Class> getClassFromJar(String jar) {
        System.out.println("上传解析");
        return null;
    }
}
