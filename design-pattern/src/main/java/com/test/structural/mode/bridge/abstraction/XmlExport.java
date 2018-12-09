package com.test.structural.mode.bridge.abstraction;

/**
 *  xml文件格式导出具体类
 */
public class XmlExport extends AbstractExport {

    @Override
    public void exportFile() {
        String readContent = iDataSource.readContent();
        System.out.println(readContent + "，将内容导出为.xml格式");
    }
}
