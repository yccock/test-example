package com.test.excel;

import com.test.excel.entity.MdcEntity;
import com.test.excel.entity.SceneEntity;
import com.test.excel.entity.UmpEntity;
import com.test.excel.export.ExcelExport;
import com.test.excel.handler.MdcDataHandler;
import com.test.excel.handler.SceneDataHandler;
import com.test.excel.handler.UmpDataHandler;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestExport {
    @Test
    public void test() throws IOException {
        ExcelExport excelExport = new ExcelExport();
        excelExport.initAnnotation(SceneEntity.class)
                .initAnnotation(UmpEntity.class)
                .initAnnotation(MdcEntity.class);
        for (int i = 0; i < 2; i++) {
            excelExport.createSheet("测试结果" + i)
                    .writeData(new SceneDataHandler(getSceneData(), "压测场景" + i))
                    .writeData(new UmpDataHandler(getUmpData(), "UMP汇总数据"+ i))
                    .writeData(new MdcDataHandler(getMdcData(), "UMP和MDC详细数据"+ i));
        }
        excelExport.writeFile("d:\\excel\\export.xlsx").dispose();
    }

    public List<SceneEntity> getSceneData(){
        List<SceneEntity> sceneEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SceneEntity sceneEntity = new SceneEntity();
            sceneEntity.setTaskId(10L);
            sceneEntity.setTaskName("下单测试");
            if (i == 3) {
                sceneEntity.setScriptName("test2.groovy");
            } else {
                sceneEntity.setScriptName("test.groovy");
            }
            if (i == 4 || i == 5) {
                sceneEntity.setScriptName("test3.groovy");
            }
            sceneEntity.setRemark("顶替顶替");
            sceneEntity.setTransactionName("自定义事务");
            sceneEntity.setVuser(10);
            sceneEntity.setTps("4554");
            sceneEntity.setAvg(20);
            sceneEntity.setTp50(30);
            sceneEntity.setTp99(30);
            sceneEntity.setTp999(50);
            sceneEntity.setMax(200);
            sceneEntity.setSuccessCount("12345");
            sceneEntity.setFailCount("5");
            sceneEntity.setFailureRate(0.9D);
            sceneEntity.setStartTime(new Date());
            sceneEntity.setEndTime(new Date());
            sceneEntity.setDruation(10L);
            sceneEntities.add(sceneEntity);
        }
        return sceneEntities;
    }

    public List<UmpEntity> getUmpData(){
        List<UmpEntity> umpEntities = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            UmpEntity umpEntity = new UmpEntity();
            umpEntity.setScriptId(10L);
            umpEntity.setVuser(20);
            umpEntity.setUmpKey("testKey");
            umpEntity.setTotalCount("100000");
            umpEntity.setFailCount("0");
            umpEntity.setAvg(10);
            umpEntity.setTp99(20);
            umpEntity.setTp999(30);
            umpEntity.setMax(50);
            umpEntity.setStartTime(new Date());
            umpEntity.setEndTime(new Date());
            umpEntity.setDruation(5L);
            umpEntities.add(umpEntity);
        }
        return umpEntities;
    }

    public List<MdcEntity> getMdcData(){
        List<MdcEntity> mdcEntities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MdcEntity mdcEntity = new MdcEntity();
            mdcEntity.setScriptId(20L);
            mdcEntity.setVuser(30);
            mdcEntity.setUmpKey("www.baidu.com");
            mdcEntity.setIp("192.168.0.8");
            mdcEntity.setCpu(10.0D);
            mdcEntity.setLoad(5);
            mdcEntity.setMemUsage(50.0D);
            mdcEntity.setDiskUsage(30.0D);
            mdcEntity.setDiskRead(20.0D);
            mdcEntity.setDiskWrite(30.4D);
            mdcEntity.setDiskBusy(10.6D);
            mdcEntity.setNetIn(40.0D);
            mdcEntity.setNetOut(50.0D);
            mdcEntity.setTcpConn(3);
            mdcEntity.setTotalCount("12365");
            mdcEntity.setFailCount("6");
            mdcEntity.setAvg(20);
            mdcEntity.setTp99(30);
            mdcEntity.setTp999(40);
            mdcEntity.setMax(60);
            mdcEntities.add(mdcEntity);
        }
        return mdcEntities;
    }
}
