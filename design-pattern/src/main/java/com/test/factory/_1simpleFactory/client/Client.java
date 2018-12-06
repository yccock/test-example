package com.test.factory._1simpleFactory.client;

import com.test.factory._1simpleFactory.Chart;
import com.test.factory._1simpleFactory.factory.ChartFactory;

public class Client {

    public static void main(String[] args) {
        Chart pieChart = ChartFactory.createChart("pie");
        pieChart.display();

        Chart histogramChart = ChartFactory.createChart("histogram");
        histogramChart.display();
    }
}
