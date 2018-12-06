package com.test.prototype._3practise;

/**
 * 软件需求规格说明书(Software	Requirements	Specification)类
 */
public class SRS implements OfficialDocument {
    @Override
    public OfficialDocument clone() {
        OfficialDocument officialDocument;
        try {
            officialDocument = (OfficialDocument) super.clone();
            return officialDocument;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("不支持复制");
        }
        return null;
    }

    @Override
    public void display() {
        System.out.println("软件需求规格说明书");
    }
}
