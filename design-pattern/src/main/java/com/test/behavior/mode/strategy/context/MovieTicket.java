package com.test.behavior.mode.strategy.context;

import com.test.behavior.mode.strategy.strategy.IDiscount;

/**
 *  电影票类
 *  环境(Context)角色：持有一个Strategy的引用
 */
public class MovieTicket {

    private double price;

    private IDiscount iDiscount;

    /**
     * 调用折扣类的折扣价计算方法
     *
     */
    public double getDiscountPrice() {
        return iDiscount.calculate(this.price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setiDiscount(IDiscount iDiscount) {
        this.iDiscount = iDiscount;
    }
}
