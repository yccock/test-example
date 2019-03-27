package com.test.excel.entity;


import com.test.excel.anno.ExcelField;

import java.util.Date;

public class SceneEntity {

    @ExcelField(title="任务Id", align=2, sort=1, width = 10)
    private Long taskId;

    @ExcelField(title="任务名称", align=2, sort=1, width = 30)
    private String taskName;

    @ExcelField(title="脚本名", align=2, sort=10, width = 20)
    private String scriptName; //脚本名

    @ExcelField(title="备注", align=2, sort=20, width = 30)
    private String remark;

    @ExcelField(title="事务名", align=2, sort=30, width = 20)
    private String transactionName; //事务名

    @ExcelField(title="并发数", align=2, sort=40, width = 20)
    private Integer vuser;

    @ExcelField(title="tps", align=2, sort=50, width = 20)
    private String tps;

    @ExcelField(title="平均响应时间(ms)", align=2, sort=60, width = 20)
    private Integer avg;

    @ExcelField(title="tp50(ms)", align=2, sort=70, width = 20)
    private Integer tp50;

    @ExcelField(title="tp99(ms)", align=2, sort=80, width = 20)
    private Integer tp99;

    @ExcelField(title="tp999(ms)", align=2, sort=90, width = 20)
    private Integer tp999;

    @ExcelField(title="最大响应时间(ms)", align=2, sort=100, width = 20)
    private Integer max; //最大响应时间

    @ExcelField(title="成功事务数", align=2, sort=110, width = 20)
    private String successCount;

    @ExcelField(title="失败事务数", align=2, sort=120, width = 20)
    private String failCount;

    @ExcelField(title="失败率", align=2, sort=130, width = 20)
    private Double failureRate; //失败率

    @ExcelField(title="开始时间", align=2, sort=140, width = 20)
    private Date startTime;

    @ExcelField(title="结束时间", align=2, sort=150, width = 20)
    private Date endTime;

    @ExcelField(title="运行时长(min)", align=2, sort=160, width = 20)
    private Long druation;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public Integer getVuser() {
        return vuser;
    }

    public void setVuser(Integer vuser) {
        this.vuser = vuser;
    }

    public String getTps() {
        return tps;
    }

    public void setTps(String tps) {
        this.tps = tps;
    }

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }

    public Integer getTp50() {
        return tp50;
    }

    public void setTp50(Integer tp50) {
        this.tp50 = tp50;
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

    public String getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(String successCount) {
        this.successCount = successCount;
    }

    public String getFailCount() {
        return failCount;
    }

    public void setFailCount(String failCount) {
        this.failCount = failCount;
    }

    public Double getFailureRate() {
        return failureRate;
    }

    public void setFailureRate(Double failureRate) {
        this.failureRate = failureRate;
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
