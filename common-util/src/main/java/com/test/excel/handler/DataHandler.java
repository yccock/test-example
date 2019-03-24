package com.test.excel.handler;


import com.test.excel.export.AbstractExport;

public interface DataHandler<T> {

    public void handle(AbstractExport export);
}
