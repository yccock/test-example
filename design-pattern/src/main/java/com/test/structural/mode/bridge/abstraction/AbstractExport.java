package com.test.structural.mode.bridge.abstraction;

import com.test.structural.mode.bridge.implementor.IDataSource;

/**
 * 文件格式导出 抽象类
 * 桥接关联数据源类
 */
public abstract class AbstractExport {

    IDataSource iDataSource;

    public void setResource(IDataSource iDataSource) {
        this.iDataSource = iDataSource;
    }

    public abstract void exportFile();
}
