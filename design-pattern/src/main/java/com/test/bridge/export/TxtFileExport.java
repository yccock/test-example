package com.test.bridge.export;

/**
 *  txt文件格式导出具体类
 */
public class TxtFileExport extends FileExportAbstract {

    @Override
    public void exportFile() {
        String readContent = iReadContent.readContent();
        System.out.println(readContent + "，将内容导出为.txt格式");
    }
}
