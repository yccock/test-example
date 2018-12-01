package com.test.attach;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;


public class MockAgent {

    // 指定我们要修改字节码的类的全限定名
    private static final String CLASS_NAME = "xxxCommonBO";
    @SuppressWarnings("rawtypes")
    public static void agentmain(String agentArgs, Instrumentation inst) throws UnmodifiableClassException {
        System.out.println("loadagent after main...");
        //获取当前JVM已经加载过的所有类
        Class[] classes =  inst.getAllLoadedClasses();
        for (Class clazz : classes) {
            //找到需要修改的类
            if(clazz.getName().equals(CLASS_NAME)) {
                System.out.println("find class " + CLASS_NAME);
                //按照要求字节吗
                inst.addTransformer(new CommonTransformer(), true);
                //让JVM重新加载修改过字节码的类
                inst.retransformClasses(clazz);
            }
        }
        System.out.println("loadagent after main sucess...");
    }
}
