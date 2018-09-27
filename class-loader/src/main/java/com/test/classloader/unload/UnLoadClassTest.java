package com.test.classloader.unload;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class UnLoadClassTest {

    public static void test() throws IOException, CustomException {
        String lib = System.getProperty("user.dir") + File.separator + "class-loader" + File.separator + "lib";
        File libFile = new File(lib);
        while (true) {
            SimpleClassLoader classLoader = new SimpleClassLoader();
            for (File file : libFile.listFiles()) {
                classLoader.addJarFile(file);
            }
            Set<Class> classes = classLoader.findInterfaceClassesByJarFile(new File(lib, "json-path-2.4.0.jar"));
            for (Class aClass : classes) {
                aClass = null;
            }
            classLoader = null;
//            System.gc();
        }
    }

    /**
     * 运行的时候配置VM参数: -verbose:class；用于查看class的加载与卸载情况
     * -Xmx512m -Xms512m -Xss128k -verbose:class
     * @param args
     */
    public static void main(String[] args) throws IOException, CustomException {
//        UnLoadClassTest.test();

        File jar1 = new File("D:\\lib\\1.0.0\\us-store-service-1.0.jar");
        SimpleClassLoader classLoader1 = new SimpleClassLoader();
        classLoader1.addJarFile(jar1);
        File libFile1 = new File("D:\\lib\\1.0.0\\lib");
        for (File file : libFile1.listFiles()) {
            classLoader1.addJarFile(file);
        }
        try {
            Set<Class> classes1 = classLoader1.findInterfaceClassesByJarFile(jar1);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        classLoader1.unloadJarFiles();

        File jar2 = new File("D:\\lib\\1.1.5\\us-store-service-1.1.5.jar");
        SimpleClassLoader classLoader2 = new SimpleClassLoader();
        classLoader2.addJarFile(jar2);
        File libFile2 = new File("D:\\lib\\1.1.5\\lib");
        for (File file : libFile2.listFiles()) {
            classLoader2.addJarFile(file);
        }

        try {
            Set<Class> classes2 = classLoader2.findInterfaceClassesByJarFile(jar2);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        classLoader2.unloadJarFiles();
    }
}
