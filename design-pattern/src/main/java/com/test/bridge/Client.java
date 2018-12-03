package com.test.bridge;

import com.test.bridge.export.PdfFileExport;
import com.test.bridge.export.TxtFileExport;
import com.test.bridge.service.ReadContentFromMySql;
import com.test.bridge.service.ReadContentFromOracle;
import com.test.bridge.service.ReadContentFromSqlServer;

public class Client {

    public static void main(String[] args) {
        ReadContentFromMySql fromMySql = new ReadContentFromMySql();
        ReadContentFromSqlServer fromSqlServer = new ReadContentFromSqlServer();
        ReadContentFromOracle fromOracle = new ReadContentFromOracle();

        //从mysql中导出pdf格式
        PdfFileExport pdfFileExport = new PdfFileExport();
        pdfFileExport.setResource(fromMySql);
        pdfFileExport.exportFile();

        //从oracle中导出txt格式
        TxtFileExport txtFileExport = new TxtFileExport();
        txtFileExport.setResource(fromOracle);
        txtFileExport.exportFile();
    }
}
