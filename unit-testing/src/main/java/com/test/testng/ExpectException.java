package com.test.testng;

import org.testng.annotations.Test;

/**
 * 在我们期望结果为某一个异常的时候
 */
public class ExpectException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionSuccess(){
        System.out.println("这是一个成功异常测试");
        throw new RuntimeException();
    }
}
