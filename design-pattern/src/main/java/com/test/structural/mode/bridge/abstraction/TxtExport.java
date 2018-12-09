package com.test.structural.mode.bridge.abstraction;

/**
 *  txt文件格式导出具体类
 */
public class TxtExport extends AbstractExport {

    @Override
    public void exportFile() {
        String readContent = iDataSource.readContent();
        System.out.println(readContent + "，将内容导出为.txt格式");
    }
}
