package com.test.behavior.mode.Iterator;

import com.test.behavior.mode.Iterator.aggregate.AbstractObjectList;
import com.test.behavior.mode.Iterator.aggregate.ProductList;
import com.test.behavior.mode.Iterator.iterator.AbstractIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 公司开发人员设计了一个抽象的数据集合类AbstractObjectList，而将存储商品和客户等数据的类作为其子类
 * AbstractObjectList充当抽象聚合类，ProductList充当具体聚合类，AbstractIterator充
 * 当抽象迭代器，ProductIterator充当具体迭代器
 */
public class Client {

    public static void main(String[] args) {
        List products = new ArrayList();
        products.add("洗面奶");
        products.add("电脑");
        products.add("冰箱");
        products.add("衣服");
        products.add("电视");

        AbstractObjectList productList = new ProductList(products); 	//创建聚合对象
        AbstractIterator productIterator = productList.createIterator();  //创建迭代器对象
        System.out.println("正向遍历：");
        while (!productIterator.isLast()) {
            System.out.println(productIterator.getNextItem());
            productIterator.next();
        }

        System.out.println("-----------------------------");
        System.out.println("逆向遍历：");
        while (!productIterator.isFirst()) {
            System.out.println(productIterator.getPreviousItem());
            productIterator.previous();
        }
    }
}
