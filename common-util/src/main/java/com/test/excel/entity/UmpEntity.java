package com.test.excel.entity;


import com.test.excel.anno.ExcelField;

import java.util.Date;


public class UmpEntity {

    private Long scriptId;

    @ExcelField(title="并发数", align=2, sort=10, width = 10)
    private Integer vuser;

    @ExcelField(title="KEY", align=2, sort=20, width = 30)
    private String umpKey;

    @ExcelField(title="总调用次数", align=2, sort=30, width = 20)
    private String totalCount;

    @ExcelField(title="失败次数", align=2, sort=40, width = 20)
    private String failCount;

    @ExcelField(title="平均响应时间(ms)", align=2, sort=50, width = 20)
    private Integer avg;

    @ExcelField(title="tp99(ms)", align=2, sort=60, width = 20)
    private Integer tp99;

    @ExcelField(title="tp999(ms)", align=2, sort=70, width = 20)
    private Integer tp999;

    @ExcelField(title="最大响应时间(ms)", align=2, sort=80, width = 20)
    private Integer max; //最大响应时间

    @ExcelField(title="开始时间", align=2, sort=90, width = 20)
    private Date startTime;

    @ExcelField(title="结束时间", align=2, sort=100, width = 20)
    private Date endTime;

    @ExcelField(title="运行时长(min)", align=2, sort=110, width = 20)
    private Long druation;

    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public Integer getVuser() {
        return vuser;
    }

    public void setVuser(Integer vuser) {
        this.vuser = vuser;
    }

    public String getUmpKey() {
        return umpKey;
    }

    public void setUmpKey(String umpKey) {
        this.umpKey = umpKey;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getFailCount() {
        return failCount;
    }

    public void setFailCount(String failCount) {
        this.failCount = failCount;
    }

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }

    public Integer getTp99() {
        return tp99;
    }

    public void setTp99(Integer tp99) {
        this.tp99 = tp99;
    }

    public Integer getTp999() {
        return tp999;
    }

    public void setTp999(Integer tp999) {
        this.tp999 = tp999;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getDruation() {
        return druation;
    }

    public void setDruation(Long druation) {
        this.druation = druation;
    }
}
