package com.test.javassist.demo2;

import javassist.*;

public class JavassistAop2 {

    public static void main(String[] args) throws NotFoundException, CannotCompileException,
            IllegalAccessException, InstantiationException {
        // 需要修改的类名和方法名
        String className = "com.test.javassist.demo2.Hello";
        String methodName = "print";

        CtClass ctClass = ClassPool.getDefault().getCtClass(className);
        CtMethod ctMethod = ctClass.getDeclaredMethod(methodName);
        //修改原来类的方法print名为print$impl
        String newMethodName = methodName + "$impl";
        ctMethod.setName(newMethodName);

        //使用原始方法名print，新定义一个方法，在这个方法内部调用print$impl
        CtMethod newMethod = CtNewMethod.make("public void " + methodName + "(){" +
                "long start = System.currentTimeMillis();" +
                newMethodName + "();" +
                "System.out.println(\"====\" + (System.currentTimeMillis() - start));" +
                "}"
                , ctClass);
        ctClass.addMethod(newMethod);

        //调用新创建的print方法
        Hello hello = (Hello) ctClass.toClass().newInstance();
        hello.print();
    }
}
