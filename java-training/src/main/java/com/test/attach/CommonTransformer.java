package com.test.attach;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 修改字节码的代码
 */
public class CommonTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        String compareClass = className.replace('/', '.');
        System.out.println("transformer..." + compareClass);
        try {
            //构建javassist需要ClassPool
            ClassPool classPool = ClassPool.getDefault();
            //把要修改的类的classpath加入到javassist的ClassPool中
            classPool.appendClassPath("/xxx/WEB-INF/lib/*");
            //从磁盘上读取要修改类的字节码，并且转换成javassit中的CtClass模型
            CtClass ctClass = classPool.get(compareClass);
            //获取需要修改的字节码的方法
            CtMethod ctMethod = ctClass.getDeclaredMethod("isFromA");
            //修改方法体
            ctMethod.setBody("return true;");
            //写入修改后的字节码
            ctClass.writeFile();
            return ctClass.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
