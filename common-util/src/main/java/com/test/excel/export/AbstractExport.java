package com.test.excel.export;

import com.test.excel.constant.ExcelConstant;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractExport implements Export{

    private static final Logger logger = LoggerFactory.getLogger(AbstractExport.class);

    protected SXSSFWorkbook workbook;

    protected Sheet sheet;

    protected Map<String, CellStyle> styles;

    protected int rownum;

    private FileOutputStream fos;

    protected HashMap<String, List<Object[]>> annotationMap = new HashMap<>();

    public AbstractExport() {
        this.workbook = new SXSSFWorkbook();
        this.styles = createStyles(workbook);
    }

    public Export createSheet(String sheetName){
        this.sheet = workbook.createSheet(sheetName);
        this.rownum = 0;
        return this;
    }

    public Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<>();

        CellStyle style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        //背景色
        style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);

        Font titleFont = wb.createFont();
        titleFont.setFontName("Arial");
        titleFont.setFontHeightInPoints((short) ExcelConstant.EXCEL_DATA_FONT_SIZE);
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        titleFont.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(titleFont);
        styles.put("title", style);

        style = wb.createCellStyle();
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short) ExcelConstant.EXCEL_DATA_FONT_SIZE);
        style.setFont(dataFont);
        styles.put("data", style);

        //align left
        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(CellStyle.ALIGN_LEFT);
        styles.put("data1", style);

        //align center
        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(CellStyle.ALIGN_CENTER);
        styles.put("data2", style);

        //align right
        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        styles.put("data3", style);

        //align auto
        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        Font headerFont = wb.createFont();
        headerFont.setFontName("Arial");
        headerFont.setFontHeightInPoints((short) ExcelConstant.EXCEL_DATA_FONT_SIZE);
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(headerFont);
        styles.put("header", style);
        return styles;
    }

    @Override
    public Export writeFile(String filename) throws IOException {
        fos = new FileOutputStream(filename);
        this.workbook.write(fos);
        return this;
    }

    // @Override
    // public Export writeResponse(HttpServletResponse response, String fileName) throws IOException {
    //     response.reset();
    //     response.setContentType("application/octet-stream; charset=utf-8");
    //     response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "utf-8"));
    //     workbook.write(response.getOutputStream());
    //     return this;
    // }

    public Row addRow() {
        return sheet.createRow(rownum++);
    }

    @Override
    public void dispose() {
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }



    public Map<String, CellStyle> getStyles() {
        return styles;
    }

    public int getRownum() {
        return rownum;
    }

    public void setRownum(int rownum) {
        this.rownum = rownum;
    }

    public HashMap<String, List<Object[]>> getAnnotationMap() {
        return annotationMap;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public SXSSFWorkbook getWorkbook() {
        return workbook;
    }
}
