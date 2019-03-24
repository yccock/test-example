package com.test.excel.export;


import com.test.excel.anno.ExcelField;
import com.test.excel.handler.DataHandler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ExcelExport extends AbstractExport {

    public ExcelExport(String sheetName) {
        super(sheetName);
    }

    public ExcelExport initAnnotation(Class<?> clazz){
        List<Object[]> annotationList = new ArrayList<>();
        // Get annotation field
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            ExcelField excelField = field.getAnnotation(ExcelField.class);
            if (excelField != null){
                annotationList.add(new Object[]{excelField, field});
            }
        }
        // Field sorting
        Collections.sort(annotationList, new Comparator<Object[]>() {
            public int compare(Object[] o1, Object[] o2) {
                return new Integer(((ExcelField)o1[0]).sort()).compareTo(
                        new Integer(((ExcelField)o2[0]).sort()));
            };
        });
        annotationMap.put(clazz.getSimpleName(), annotationList);
        return this;
    }

    @Override
    public Export writeData(DataHandler dataHandler) {
        dataHandler.handle(this);
        return this;
    }
}
