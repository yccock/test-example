package com.test.excel.handler;

import com.test.excel.anno.ExcelField;
import com.test.excel.constant.ExcelConstant;
import com.test.excel.entity.MdcEntity;
import com.test.excel.export.AbstractExport;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MdcDataHandler extends AbstractDataHandler<MdcEntity>{

    private static final Logger logger = LoggerFactory.getLogger(MdcDataHandler.class);

    private List<MdcEntity> mdcEntities;

    public MdcDataHandler(List<MdcEntity> sceneEntities, String title) {
        super(title);
        this.mdcEntities = sceneEntities;
    }

    @Override
    public void handle(AbstractExport export) {
        super.init(export);
        this.writeHeader();
        int firstRowNum = writeTableData(mdcEntities);
        List<Integer[]> scriptIds = mergeByScriptId(mdcEntities);
        for (Integer[] region : scriptIds) {
            sheet.addMergedRegion(new CellRangeAddress(firstRowNum + region[0], firstRowNum + region[1], 0, 0));
        }
    }

    public void writeHeader() {
        export.addRow();
        export.addRow();
        List<String> headerList = new ArrayList<>();
        List<Integer> widthList = new ArrayList<>();
        for (Object[] objects : annotationList) {
            String header = ((ExcelField) objects[0]).title();
            int width = ((ExcelField) objects[0]).width();
            headerList.add(header);
            widthList.add(width);
        }
        if (headerList.size() == 0) {
            logger.error("{}: header size is 0");
            throw new RuntimeException(" header size is 0");
        }
        CellStyle titleStyle = export.getStyles().get("title");
        CellStyle headerStyle = export.getStyles().get("header");

        //一级标题
        Row titleRow1 = export.addRow();
        titleRow1.setHeightInPoints(ExcelConstant.EXCEL_LINE_HEIGHT_20);
        for (int i = 0; i < annotationList.size(); i++) {
            Cell titleCell = titleRow1.createCell(i);
            titleCell.setCellStyle(titleStyle);
            titleCell.setCellValue(title);
        }
        sheet.addMergedRegion(new CellRangeAddress(titleRow1.getRowNum(), titleRow1.getRowNum(), 0, headerList.size() - 1));

        //二级标题row
        Row titleRow2 = export.addRow();
        titleRow2.setHeightInPoints(ExcelConstant.EXCEL_LINE_HEIGHT_20);
        //设置二级标题前3列header
        for (int i = 0; i <3; i++) {
            Cell titleCell00 = titleRow2.createCell(i);
            titleCell00.setCellStyle(headerStyle);
            titleCell00.setCellValue(headerList.get(i));
        }

        //从第3-13列开始
        int colNum = 3;
        for (int i = 3; i < 13; i++) {
            Cell titleCell2 = titleRow2.createCell(i);
            titleCell2.setCellStyle(titleStyle);
            titleCell2.setCellValue("MDC数据");
        }
        sheet.addMergedRegion(new CellRangeAddress(titleRow2.getRowNum(), titleRow2.getRowNum(), colNum, 12));

        //从第13列开始
        colNum = 13;
        for (int i = colNum; i < annotationList.size(); i++) {
            Cell titleCell3 = titleRow2.createCell(i);
            titleCell3.setCellStyle(titleStyle);
            titleCell3.setCellValue("UMP数据");
        }
        sheet.addMergedRegion(new CellRangeAddress(titleRow2.getRowNum(), titleRow2.getRowNum(), colNum, headerList.size() - 1));

        Row headerRow = export.addRow();
        headerRow.setHeightInPoints(ExcelConstant.EXCEL_LINE_HEIGHT_30);
        for (int i = 0; i < headerList.size(); i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellStyle(styles.get("header"));
            headerCell.setCellValue(headerList.get(i));
            sheet.setColumnWidth(i, widthList.get(i) * 256);
        }
        //合并前3行上下列
        for (int i = 0; i < 3; i++) {
            sheet.addMergedRegion(new CellRangeAddress(headerRow.getRowNum() -1, headerRow.getRowNum(), i, i));
        }
    }


    public List<Integer[]> mergeByScriptId(List<MdcEntity> mdcEntities){
        List<Integer[]> mergeRegions = new ArrayList<>();
        for (int i = 0; i < mdcEntities.size(); i++) {
            int firstRow = -1, lastRow = -1;
            for (int j = i + 1; j < mdcEntities.size(); j++) {
                if (mdcEntities.get(i).getScriptId().equals(mdcEntities.get(j).getScriptId())) {
                    if (firstRow == -1) {
                        firstRow = i;
                    }
                    lastRow = j;
                } else {
                    if (lastRow > -1) {
                        mergeRegions.add(new Integer[]{firstRow, lastRow});
                        i = j;
                        firstRow = -1;
                        lastRow = -1;
                    }
                }
            }
            if (lastRow > -1) {
                mergeRegions.add(new Integer[]{firstRow, lastRow});
                i = lastRow;
            }
        }
        return mergeRegions;
    }
}
