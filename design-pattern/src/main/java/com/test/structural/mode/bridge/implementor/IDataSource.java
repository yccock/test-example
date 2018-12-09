package com.test.structural.mode.bridge.implementor;


/**
 * 获取文件内容、连接数据库来源接口
 */
public interface IDataSource {

    /**
     * 读取数据库中的内容
     * @return
     */
    public String readContent();

}
