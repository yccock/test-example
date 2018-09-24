package com.test.classloader.unload;

import java.net.MalformedURLException;
import java.net.URL;

public class UnLoadClassTest {

    /**
     * 运行的时候配置VM参数: -verbose:class；用于查看class的加载与卸载情况
     * @param args
     */
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        String path = "D:\\Workspaces\\GitHubWorkspaces\\test-example\\common-util\\target\\classes";
        URL url = new URL(path);
        SimpleClassLoader classLoader = new SimpleClassLoader(new URL[]{url});
        Class<?> aClass = classLoader.loadClass(UnLoadClass.class.getCanonicalName());

        aClass = null;
        classLoader = null;
        System.gc();

        System.out.println("system gc ....");
    }
}
