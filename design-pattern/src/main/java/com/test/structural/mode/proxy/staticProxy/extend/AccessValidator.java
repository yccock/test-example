package com.test.structural.mode.proxy.staticProxy.extend;

/**
 * ：身份验证类，业务类，它提供方法Validate()来实现身份验证
 */
public class AccessValidator {

    public boolean Validate(String userId) {
        if (userId.equals("test")) {
            System.out.println(userId + "登录成功");
            return true;
        } else {
            System.out.println(userId + "登录失败");
            return false;
        }
    }
}
