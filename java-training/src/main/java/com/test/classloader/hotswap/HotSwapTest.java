package com.test.classloader.hotswap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HotSwapTest {
    // Hot类就是用于修改，用来测试热加载
    private String className = Hot.class.getCanonicalName();

    private HostSwapClassLoader classLoader;

    private Class<?> hotClass;

    private void init() throws ClassNotFoundException {
//        classLoader = new HostSwapClassLoader();
        //  如果Hot类被修改了，那么会重新加载，hotClass也会返回新的
        hotClass = this.classLoader.loadClass(this.className);
    }

    private void start() {
        while (true) {
            try {
                this.init();
                Object hot = hotClass.newInstance();
                Method show = hotClass.getMethod("show");
                show.invoke(hot, null);//调用show方法
                Thread.sleep(10000);//10秒打印一次
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new HotSwapTest().start();
    }
}
