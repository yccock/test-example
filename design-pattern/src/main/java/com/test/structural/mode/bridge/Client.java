package com.test.structural.mode.bridge;

import com.test.structural.mode.bridge.abstraction.PdfExport;
import com.test.structural.mode.bridge.abstraction.TxtExport;
import com.test.structural.mode.bridge.implementor.MySqlDataSource;
import com.test.structural.mode.bridge.implementor.OracleDataSource;
import com.test.structural.mode.bridge.implementor.SqlServerDataSource;

/**
 * 根据需要，分别从mysql,sqlserver,oracle中导出pdf,txt,xml格式数据
 */
public class Client {

    public static void main(String[] args) {
        MySqlDataSource fromMySql = new MySqlDataSource();
        SqlServerDataSource fromSqlServer = new SqlServerDataSource();
        OracleDataSource fromOracle = new OracleDataSource();

        //从mysql中导出pdf格式
        PdfExport pdfExport = new PdfExport();
        pdfExport.setResource(fromMySql);
        pdfExport.exportFile();

        //从oracle中导出txt格式
        TxtExport txtExport = new TxtExport();
        txtExport.setResource(fromOracle);
        txtExport.exportFile();
    }
}
