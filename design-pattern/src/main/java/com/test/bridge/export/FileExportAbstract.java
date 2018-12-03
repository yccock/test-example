package com.test.bridge.export;

import com.test.bridge.service.IReadContent;

/**
 * 文件格式导出 抽象类
 */
public abstract class FileExportAbstract {

    IReadContent iReadContent;

    public void setResource(IReadContent iReadContent) {
        this.iReadContent = iReadContent;
    }

    public abstract void exportFile();
}
