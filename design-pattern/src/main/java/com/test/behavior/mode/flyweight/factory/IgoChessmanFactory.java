package com.test.behavior.mode.flyweight.factory;

import com.test.behavior.mode.flyweight.flyweight.BlackIgoChessman;
import com.test.behavior.mode.flyweight.flyweight.IgoChessman;
import com.test.behavior.mode.flyweight.flyweight.WhiteIgoChessman;

import java.util.HashMap;

/**
 * 围棋棋子工厂类：享元工厂类，使用单例模式进行设计
 */
public class IgoChessmanFactory {

    private static IgoChessmanFactory chessmanFactory = new IgoChessmanFactory();

    private static HashMap<String, IgoChessman> hashMap;

    private IgoChessmanFactory() {
        hashMap = new HashMap();
        BlackIgoChessman black = new BlackIgoChessman();
        hashMap.put("black", black);
        WhiteIgoChessman white = new WhiteIgoChessman();
        hashMap.put("white", white);
    }

    public static IgoChessmanFactory getInstance() {
        return chessmanFactory;
    }

    public static IgoChessman getIgoChessman(String key) {
        return hashMap.get(key);
    }
}
