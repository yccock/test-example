package com.test.behavior.mode.strategy;

import com.test.behavior.mode.strategy.context.MovieTicket;
import com.test.behavior.mode.strategy.strategy.StudentDiscount;

public class Client {

    public static void main(String[] args) {
        double originalPrice = 60.0;
        MovieTicket movieTicket = new MovieTicket();
        movieTicket.setPrice(originalPrice);
        movieTicket.setiDiscount(new StudentDiscount());
        System.out.println("折后价为："	+	movieTicket.getDiscountPrice());
    }
}
