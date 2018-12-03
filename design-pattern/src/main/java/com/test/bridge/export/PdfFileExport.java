package com.test.bridge.export;

/**
 *  pdf文件格式导出具体类
 */
public class PdfFileExport extends FileExportAbstract {

    @Override
    public void exportFile() {
        String readContent = iReadContent.readContent();
        System.out.println(readContent + "，将内容导出为.pdf格式");
    }
}
