package com.test.behavior.mode.flyweight.unshared;

/**
 * 坐标类：外部状态类
 * 	外部状态是随环境改变而改变的、不可以共享的状态。享元对象的外部状态通常由客户端
 *  保存，并在享元对象被创建之后，需要使用的时候再传入到享元对象内部
 */
public class Coordinates {
    private	int	x;
    private	int	y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
