package com.test.create.mode.prototype._3practise;

/**
 * 可行性分析报告(Feasibility	Analysis Report)类
 */
public class FAR implements OfficialDocument {
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
        System.out.println("可行性分析报告");
    }
}
