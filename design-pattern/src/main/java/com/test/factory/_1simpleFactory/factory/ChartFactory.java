package com.test.factory._1simpleFactory.factory;

import com.test.factory._1simpleFactory.Chart;
import com.test.factory._1simpleFactory.HistogramChart;
import com.test.factory._1simpleFactory.PieChart;

/**
 * 工厂类
 */
public class ChartFactory {

    public static Chart createChart(String type) {
        Chart chart = null;
        if (type.equals("histogram")) {
            chart = new HistogramChart();
            System.out.println("初始化设置柱状图");
        } else if (type.equals("pie")) {
            chart = new PieChart();
            System.out.println("初始化设置饼图");
        }
        return chart;
    }
}
