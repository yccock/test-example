package com.test.excel.handler;

import com.test.excel.anno.ExcelField;
import com.test.excel.constant.ExcelConstant;
import com.test.excel.export.AbstractExport;
import com.test.excel.util.ReflectUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class AbstractDataHandler<T> implements DataHandler<T>{

    private static final Logger logger = LoggerFactory.getLogger(AbstractDataHandler.class);

    protected AbstractExport export;

    protected Workbook workbook;

    protected Sheet sheet;

    protected List<Object[]> annotationList;

    protected Map<String, CellStyle> styles;

    protected String title;

    public AbstractDataHandler(String title) {
        this.title = title;
    }

    public void init(AbstractExport export) {
        this.export = export;
        this.styles = export.getStyles();
        this.workbook = export.getWorkbook();
        this.sheet = export.getSheet();
        Class<T> entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.annotationList = export.getAnnotationMap().get(entityClass.getSimpleName());
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
        Row titleRow = export.addRow();
        titleRow.setHeightInPoints(ExcelConstant.EXCEL_LINE_HEIGHT_20);
        for (int i = 0; i < annotationList.size(); i++) {
            Cell titleCell = titleRow.createCell(i);
            titleCell.setCellStyle(export.getStyles().get("title"));
            titleCell.setCellValue(title);
        }
        sheet.addMergedRegion(new CellRangeAddress(titleRow.getRowNum(), titleRow.getRowNum(),
                0, headerList.size() - 1));

        Row headerRow = export.addRow();
        headerRow.setHeightInPoints(ExcelConstant.EXCEL_LINE_HEIGHT_30);
        for (int i = 0; i < headerList.size(); i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellStyle(styles.get("header"));
            headerCell.setCellValue(headerList.get(i));
            sheet.setColumnWidth(i, widthList.get(i) * 256);
        }
    }

    public <T> int writeTableData(List<T> list){
        int firstRowNum = 0; //当前表格数据的第一行行号
        for (int i = 0; i < list.size(); i++) {
            Row row = export.addRow();
            if (i == 0) {
                firstRowNum = row.getRowNum();
            }
            int column = 0;
            for (Object[] objects : annotationList) {
                Object val = null;
                ExcelField excelField = (ExcelField) objects[0];
                int align = excelField.align();
                if (objects[1] instanceof Field) {
                    String propertyName = ((Field) objects[1]).getName();
                    try {
                        val = ReflectUtil.invokeGetter(list.get(i), propertyName);
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                }
                addCell(row, column++, val, align);
            }
        }
        return firstRowNum;
    }

    public Cell addCell(Row row, int column, Object val, int align) {
        CellStyle cellStyle = export.getStyles().get("data" + (align >= 1 && align <= 3 ? align : ""));
        Cell cell = row.createCell(column);
        String cellFormatString = "@"; //文本类型
        try {
            if (val == null) {
                cell.setCellValue("-");
            } else if (val instanceof String) {
                cell.setCellValue((String) val);
            } else if (val instanceof Integer) {
                cell.setCellValue((Integer) val);
                cellFormatString = "0";
            } else if (val instanceof Long) {
                cell.setCellValue((Long) val);
                cellFormatString = "0";
            } else if (val instanceof Double) {
                cell.setCellValue((Double) val);
                cellFormatString = "0.00";
            } else if (val instanceof Float) {
                cell.setCellValue((Float) val);
                cellFormatString = "0.00";
            } else if (val instanceof Date) {
                // cell.setCellValue((Date) val);
                // cellFormatString = "yyyy-MM-dd HH:mm:ss";
                Date date = (Date) val;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                cell.setCellValue(sdf.format(date));
            }
            DataFormat format = workbook.createDataFormat();
            cellStyle.setDataFormat(format.getFormat(cellFormatString));
            cell.setCellStyle(cellStyle);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return cell;
    }
}
