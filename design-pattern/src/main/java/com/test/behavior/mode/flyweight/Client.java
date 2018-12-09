package com.test.behavior.mode.flyweight;

import com.test.behavior.mode.flyweight.factory.IgoChessmanFactory;
import com.test.behavior.mode.flyweight.flyweight.IgoChessman;
import com.test.behavior.mode.flyweight.unshared.Coordinates;

/**
 * 为了节约存储空间，提高系统性能，使用享元模式来设计围棋软件中的棋子
 */
public class Client {

    public static void main(String[] args) {
        IgoChessman black1, black2, black3, white1, white2;
        IgoChessmanFactory factory;

        //获取享元工厂对象
        factory = IgoChessmanFactory.getInstance();
        //通过享元工厂获取三颗黑子
        black1 = factory.getIgoChessman("black");
        black2 = factory.getIgoChessman("black");
        black3 = factory.getIgoChessman("black");
        System.out.println("判断两颗黑子是否相同：" + (black1 == black2));

        //通过享元工厂获取两颗白子
        white1 = factory.getIgoChessman("white");
        white2 = factory.getIgoChessman("white");
        System.out.println("判断两颗白子是否相同：" + (white1 == white2));

        //显示棋子，同时设置棋子的坐标位置	，注入外部类
        black1.display(new Coordinates(1, 2));
        black2.display(new Coordinates(2, 3));
        black3.display(new Coordinates(1, 2));
        white1.display(new Coordinates(3, 4));
        white2.display(new Coordinates(5, 6));
    }
}
