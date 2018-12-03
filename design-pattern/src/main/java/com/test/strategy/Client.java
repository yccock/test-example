package com.test.strategy;

import com.test.strategy.strategy.SearchJarStragegy;
import com.test.strategy.strategy.UploadJarStrategy;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        Context context = new Context(new UploadJarStrategy());
        List<Class> uploadJarClasses = context.parseJar("d:\\lib\\test.jar");

        Context searchContext = new Context(new SearchJarStragegy());
        List<Class> searchJarClasses = searchContext.parseJar("test.jar");
    }
}
