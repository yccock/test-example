package com.test.behavior.mode.flyweight.flyweight;

/**
 * 白色棋子类：内部状态类
 * 内部状态是存储在享元对象内部并且不会随环境改变而改变的状态，内部状态可以共享
 */
public class WhiteIgoChessman extends IgoChessman {
    @Override
    public String getColor() {
        return "白色";
    }
}
