package com.test.prototype._3practise;

import java.util.HashMap;

/**
 * 原型管理器（使用饿汉式单例实现）
 */
public class PrototypeManager {

    private static PrototypeManager prototypeManager = new PrototypeManager();

    private HashMap hashMap = new HashMap();

    private PrototypeManager(){
        hashMap.put("far", new FAR());
        hashMap.put("srs", new SRS());
    }

    public static PrototypeManager getInstance() {
        return prototypeManager;
    }

    //增加新的公文对象
    public void addOfficialDocument(String key, OfficialDocument officialDocument) {
        hashMap.put(key, officialDocument);
    }

    //通过浅克隆获取新的公文对象
    public OfficialDocument getOfficialDocument(String key) {
        return ((OfficialDocument) hashMap.get(key)).clone();
    }
}
