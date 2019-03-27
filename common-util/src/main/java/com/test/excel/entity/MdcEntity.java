package com.test.excel.entity;

import com.test.excel.anno.ExcelField;

public class MdcEntity {

    private Long scriptId;

    @ExcelField(title="并发数", align=2, sort=10, width = 10)
    private Integer vuser;

    @ExcelField(title="key", align=2, sort=20, width = 20)
    private String umpKey;

    @ExcelField(title="ip", align=2, sort=30, width = 20)
    private String ip;

    @ExcelField(title="cpu使用率", align=2, sort=40, width = 15)
    private Double cpu;

    @ExcelField(title="cpu load", align=2, sort=50, width = 15)
    private Integer load;

    @ExcelField(title="内存使用率", align=2, sort=60, width = 10)
    private Double memUsage;

    @ExcelField(title="磁盘使用率", align=2, sort=70, width = 10)
    private Double diskUsage;

    @ExcelField(title="磁盘读流量", align=2, sort=80, width = 10)
    private Double diskRead;

    @ExcelField(title="磁盘写流量", align=2, sort=90, width = 17)
    private Double diskWrite;

    @ExcelField(title="磁盘繁忙度", align=2, sort=100, width = 17)
    private Double diskBusy;

    @ExcelField(title="网络流入速率", align=2, sort=110, width = 10)
    private Double netIn;

    @ExcelField(title="网络流出速率", align=2, sort=120, width = 10)
    private Double netOut;

    @ExcelField(title="tcp连接数", align=2, sort=130, width = 10)
    private Integer tcpConn;


    @ExcelField(title="总调用次数", align=2, sort=140, width = 10)
    private String totalCount;

    @ExcelField(title="失败次数", align=2, sort=150, width = 10)
    private String failCount;

    @ExcelField(title="平均响应时间(ms)", align=2, sort=160, width = 17)
    private Integer avg;

    @ExcelField(title="tp99(ms)", align=2, sort=170, width = 17)
    private Integer tp99;

    @ExcelField(title="tp999(ms)", align=2, sort=180, width = 10)
    private Integer tp999;

    @ExcelField(title="最大响应时间(ms)", align=2, sort=190, width = 10)
    private Integer max; //最大响应时间

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public Double getMemUsage() {
        return memUsage;
    }

    public void setMemUsage(Double memUsage) {
        this.memUsage = memUsage;
    }

    public Double getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(Double diskUsage) {
        this.diskUsage = diskUsage;
    }

    public Double getDiskRead() {
        return diskRead;
    }

    public void setDiskRead(Double diskRead) {
        this.diskRead = diskRead;
    }

    public Double getDiskWrite() {
        return diskWrite;
    }

    public void setDiskWrite(Double diskWrite) {
        this.diskWrite = diskWrite;
    }

    public Double getDiskBusy() {
        return diskBusy;
    }

    public void setDiskBusy(Double diskBusy) {
        this.diskBusy = diskBusy;
    }

    public Double getNetIn() {
        return netIn;
    }

    public void setNetIn(Double netIn) {
        this.netIn = netIn;
    }

    public Double getNetOut() {
        return netOut;
    }

    public void setNetOut(Double netOut) {
        this.netOut = netOut;
    }

    public Integer getTcpConn() {
        return tcpConn;
    }

    public void setTcpConn(Integer tcpConn) {
        this.tcpConn = tcpConn;
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
}
