package com.test.decorator;

public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.run();
        System.out.println("==========");

        //增加新的功能，飞行
        FlyCar flyCar = new FlyCar(car);
        flyCar.run();
        System.out.println("==========");

        //增加两个功能，飞行、水里游
        WaterCar waterCar = new WaterCar(new FlyCar(car));
        waterCar.run();
    }
}
