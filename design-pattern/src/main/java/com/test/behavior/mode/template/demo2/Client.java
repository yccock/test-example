package com.test.behavior.mode.template.demo2;

/**
 * 某软件公司欲为销售管理系统提供一个数据图表显示功能，该功能的实现包括如下几个步骤：
 * (1)	从数据源获取数据；
 * (2)	将数据转换为XML格式；
 * (3)	以某种图表方式显示XML格式的数据。
 * 该功能支持多种数据源和多种图表显示方式，但所有的图表显示操作都基于XML格式的数
 * 据，因此可能需要对数据进行转换，如果从数据源获取的数据已经是XML数据则无须转换。
 * 由于该数据图表显示功能的三个步骤次序是固定的，且存在公共代码（例如数据格式转换代
 * 码），满足模板方法模式的适用条件，可以使用模板方法模式对其进行设计。因为数据格式
 * 的不同，XML数据可以直接显示，而其他格式的数据需要进行转换，因此第(2)步“将数据转换
 * 为XML格式”的执行存在不确定性，为了解决这个问题，可以定义一个钩子方法
 */
public class Client {

    public static void main(String[] args) {
        DataViewer dataViewer = new XmlDataViwer();
        dataViewer.process();
    }
}
