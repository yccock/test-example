package com.test.bridge.export;

/**
 *  xml文件格式导出具体类
 */
public class XmlFileExport extends FileExportAbstract {

    @Override
    public void exportFile() {
        String readContent = iReadContent.readContent();
        System.out.println(readContent + "，将内容导出为.xml格式");
    }
}
