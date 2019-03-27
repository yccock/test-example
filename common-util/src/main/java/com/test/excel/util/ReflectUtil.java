package com.test.excel.util;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

public class ReflectUtil {

    public static Object invokeGetter(Object object, String propertyName) {
        String methodName = "get" + StringUtils.capitalize(propertyName);
        return invokeMethod(object, methodName, new Class[]{}, new Object[]{});
    }

    public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] args) {
        Method method = getAccessibleMethod(object, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
        }
        try {
            return method.invoke(object, args);
        } catch (Exception e) {
            throw new RuntimeException("get method [" + methodName + "] value exception on target [" + object + "]");
        }
    }

    public static Method getAccessibleMethod(Object object, String methodName, Class<?>[] parameterTypes) {
        Class<?> aClass = object.getClass();
        while (aClass != Object.class) {
            try {
                Method method = aClass.getDeclaredMethod(methodName, parameterTypes);
                method.setAccessible(true);
                return method;
            } catch (NoSuchMethodException e) {
            }
            aClass = aClass.getSuperclass();
        }
        return null;
    }

}
