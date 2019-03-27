package com.test.excel.handler;

import com.test.excel.entity.SceneEntity;
import com.test.excel.export.AbstractExport;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SceneDataHandler extends AbstractDataHandler<SceneEntity>{

    private static final Logger logger = LoggerFactory.getLogger(SceneDataHandler.class);

    private List<SceneEntity> sceneEntities;

    public SceneDataHandler(List<SceneEntity> sceneEntities, String title) {
        super(title);
        this.sceneEntities = sceneEntities;
    }

    @Override
    public void handle(AbstractExport export) {
        super.init(export);
        super.writeHeader();
        int firstRowNum = writeTableData(sceneEntities);
        List<Integer[]> mergeTaskIds = mergeTaskId(sceneEntities);
        for (Integer[] region : mergeTaskIds) {
            sheet.addMergedRegion(new CellRangeAddress(firstRowNum + region[0], firstRowNum + region[1], 0, 0));
            sheet.addMergedRegion(new CellRangeAddress(firstRowNum + region[0], firstRowNum + region[1], 1, 1));

        }
        List<Integer[]> mergeScriptIds = mergeByScriptName(sceneEntities);
        for (Integer[] region : mergeScriptIds) {
            sheet.addMergedRegion(new CellRangeAddress(firstRowNum + region[0], firstRowNum + region[1], 2, 2));
            sheet.addMergedRegion(new CellRangeAddress(firstRowNum + region[0], firstRowNum + region[1], 3, 3));
        }
    }

    public List<Integer[]> mergeByScriptName(List<SceneEntity> sceneEntities){
        List<Integer[]> mergeRegions = new ArrayList<>();
        for (int i = 0; i < sceneEntities.size(); i++) {
            int firstRow = -1, lastRow = -1;
            for (int j = i + 1; j < sceneEntities.size(); j++) {
                if (sceneEntities.get(i).getScriptName().equals(sceneEntities.get(j).getScriptName())) {
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

    public List<Integer[]> mergeTaskId(List<SceneEntity> sceneEntities){
        List<Integer[]> mergeRegions = new ArrayList<>();
        for (int i = 0; i < sceneEntities.size(); i++) {
            int firstRow = -1, lastRow = -1;
            for (int j = i + 1; j < sceneEntities.size(); j++) {
                if (sceneEntities.get(i).getTaskId().equals(sceneEntities.get(j).getTaskId())) {
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
