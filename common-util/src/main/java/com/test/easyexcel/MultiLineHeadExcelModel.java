package com.test.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class MultiLineHeadExcelModel extends BaseRowModel {
    @ExcelProperty(value = {"压测场景","脚本名"},index = 0)
    private String scriptName;

    @ExcelProperty(value = {"压测场景","事务名"},index = 1)
    private String transactionName;

    @ExcelProperty(value = {"压测场景","并发数"},index = 2)
    private int threadNumber;

    @ExcelProperty(value = {"压测场景","TPS"},index = 3)
    private long tps;

    @ExcelProperty(value = {"压测场景","平均响应时间"},index = 4)
    private int responseTime;

    @ExcelProperty(value = {"压测场景","失败率"},index = 5)
    private String failRate;

    @ExcelProperty(value = {"应用数据(mdc)","CPU"},index = 6)
    private String cpu;

    @ExcelProperty(value = {"应用数据(mdc)","内存使用率"},index = 7)
    private String memory;

    @ExcelProperty(value = {"应用数据(mdc)","CPU load"},index = 8)
    private String cpuLoad;

    @ExcelProperty(value = {"应用数据(mdc)","磁盘I/O"},index = 8)
    private String io;

    @ExcelProperty(value = {"应用数据(mdc)","TCP连接数"},index = 8)
    private int tcpConnNum;

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public int getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public long getTps() {
        return tps;
    }

    public void setTps(long tps) {
        this.tps = tps;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public String getFailRate() {
        return failRate;
    }

    public void setFailRate(String failRate) {
        this.failRate = failRate;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(String cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public String getIo() {
        return io;
    }

    public void setIo(String io) {
        this.io = io;
    }

    public int getTcpConnNum() {
        return tcpConnNum;
    }

    public void setTcpConnNum(int tcpConnNum) {
        this.tcpConnNum = tcpConnNum;
    }
}
