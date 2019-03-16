package com.test.easyexcel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteTest {
    List<MultiLineHeadExcelModel> list = new ArrayList<>();

    @Before
    public void init(){
        for (int i = 0; i < 10; i++) {
            MultiLineHeadExcelModel model = new MultiLineHeadExcelModel();
            model.setScriptName("baidu" + i +".groovy");
            model.setTransactionName("自定义事务名");
            model.setThreadNumber(1+i);
            model.setTps(100L);
            model.setResponseTime(2+i);
            model.setFailRate("0");
            model.setCpu("15");
            model.setMemory("25");
            model.setCpuLoad("3");
            model.setIo("4");
            model.setTcpConnNum(36+i);
            list.add(model);
        }
    }

    public TableStyle getTableStyle(){
        TableStyle tableStyle = new TableStyle();
        tableStyle.setTableHeadBackGroundColor(IndexedColors.GREEN);

        tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE);
        Font contentFont = new Font();
        contentFont.setBold(false);
        contentFont.setFontName("宋体");
        //设置字体大小
        contentFont.setFontHeightInPoints((short)12);
        tableStyle.setTableContentFont(contentFont);
        return tableStyle;
    }
    @Test
    public void testWrite() throws FileNotFoundException {
        OutputStream out = new FileOutputStream("d:\\88.xlsx");
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,true);
            Sheet sheet = new Sheet(1, 0, MultiLineHeadExcelModel.class);
            sheet.setSheetName("第一个sheet");

            sheet.setTableStyle(getTableStyle());

            writer.write(list, sheet);
            writer.merge(3, 5, 1, 1);
            writer.merge(3, 5, 2, 2);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
