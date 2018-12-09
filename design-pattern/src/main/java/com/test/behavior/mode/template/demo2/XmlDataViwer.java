package com.test.behavior.mode.template.demo2;

/**
 * @Description:
 * @Author yccock
 * @Date 2018/12/8 14:35
 */
public class XmlDataViwer extends DataViewer {
    /**
     * 实现父类方法：获取数据
     */
    @Override
    protected void getData() {
        System.out.println("从XML文件中获取数据");
    }

    /**
     * 实现父类方法：显示数据，默认以柱状图方式显示，可结合桥接模式来改进
     */
    @Override
    public void displayData() {
        System.out.println("以柱状图显示数据");
    }

    /**
     * 覆盖父类的钩子方法
     */
    @Override
    public boolean isNotXmlData() {
        return false;
    }
}
