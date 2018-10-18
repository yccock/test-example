package com.test.javassist.demo1;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//http://www.tianshouzhi.com/api/tutorials/bytecode/354
public class GeneraterUserClass {

//    class User{
//        private String name="javassist";
//        public User(String name) {
//            this.name = name;
//        }
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return "name='" + name;
//        }
//    }

    //生成如上所示User类
    public static void main(String[] args) throws NotFoundException, CannotCompileException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        ClassPool classPool = ClassPool.getDefault();
        //定义User类
        CtClass ctClassUser = classPool.makeClass("com.test.User");

        //定义name字段类型
        CtClass fieldType = classPool.get("java.lang.String");
        //字段名称
        String fieldName = "name";
        CtField ctField = new CtField(fieldType, fieldName, ctClassUser);
        //设置访问修饰符
        ctField.setModifiers(Modifier.PRIVATE);
        //添加name字段，赋值为javassist
        ctClassUser.addField(ctField, CtField.Initializer.constant("javassist"));

        //定义构造方法
        CtClass[] ctClasses = new CtClass[]{classPool.get("java.lang.String")};
        CtConstructor ctConstructor = new CtConstructor(ctClasses, ctClassUser);
        //方法体，$1表示第一个参数
        String body = "{this.name=$1;}";
        ctConstructor.setBody(body);
        ctClassUser.addConstructor(ctConstructor);

        //setName getName方法
        ctClassUser.addMethod(CtNewMethod.setter("setName", ctField));
        ctClassUser.addMethod(CtNewMethod.getter("getName", ctField));

        //toString方法
        CtClass returnType = classPool.get("java.lang.String");
        String methodName = "toString";
        CtMethod toStringMethod = new CtMethod(returnType, methodName, null, ctClassUser);
        //$0代表this
        String methodBody = "{return \"name=\" + $0.name;}";
        toStringMethod.setBody(methodBody);
        ctClassUser.addMethod(toStringMethod);

        //代表class文件的CtClass创建完成，现在将其转换成class对象
        Class<?> aClass = ctClassUser.toClass();
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object user = constructor.newInstance("test");
        Method toString = aClass.getMethod("toString");
        System.out.println(toString.invoke(user));

        //在当前目录下，生成com/test/User.class文件
        ctClassUser.writeFile("d:\\lib");
    }
}
