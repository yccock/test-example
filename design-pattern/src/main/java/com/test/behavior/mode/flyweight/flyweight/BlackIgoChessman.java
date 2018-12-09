package com.test.behavior.mode.flyweight.flyweight;

/**
 * 黑色棋子类：具体享元类
 * 内部状态是存储在享元对象内部并且不会随环境改变而改变的状态，内部状态可以共享
 */
public class BlackIgoChessman extends IgoChessman {
    @Override
    public String getColor() {
        return "黑色";
    }
}
