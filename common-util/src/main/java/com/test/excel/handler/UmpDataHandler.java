package com.test.excel.handler;

import com.test.excel.entity.UmpEntity;
import com.test.excel.export.AbstractExport;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UmpDataHandler extends AbstractDataHandler<UmpEntity>{

    private static final Logger logger = LoggerFactory.getLogger(UmpDataHandler.class);

    private List<UmpEntity> umpEntities;

    public UmpDataHandler(List<UmpEntity> umpEntities, String title) {
        super(title);
        this.umpEntities = umpEntities;
    }

    @Override
    public void handle(AbstractExport export) {
        super.init(export);
        super.writeHeader();
        int firstRowNum = writeTableData(umpEntities);
        List<Integer[]> scriptIds = mergeByScriptId(umpEntities);
        for (Integer[] region : scriptIds) {
            sheet.addMergedRegion(new CellRangeAddress(firstRowNum + region[0], firstRowNum + region[1], 0, 0));
            sheet.addMergedRegion(new CellRangeAddress(firstRowNum + region[0], firstRowNum + region[1], 8, 8));
            sheet.addMergedRegion(new CellRangeAddress(firstRowNum + region[0], firstRowNum + region[1], 9, 9));
            sheet.addMergedRegion(new CellRangeAddress(firstRowNum + region[0], firstRowNum + region[1], 10, 10));
        }
    }

    public List<Integer[]> mergeByScriptId(List<UmpEntity> umpEntities){
        List<Integer[]> mergeRegions = new ArrayList<>();
        for (int i = 0; i < umpEntities.size(); i++) {
            int firstRow = -1, lastRow = -1;
            for (int j = i + 1; j < umpEntities.size(); j++) {
                if (umpEntities.get(i).getScriptId().equals(umpEntities.get(j).getScriptId())) {
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
