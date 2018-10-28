package com.test.decorator;

//Component抽象构件角色
public interface ICar {
    void run();
}
//ConcreteComponent具体构建角色（真实对象）
class Car implements ICar {
    @Override
    public void run() {
        System.out.println("陆地上跑");
    }
}
//Decorator装饰角色
class Decorator implements ICar{
    protected ICar car;
    public Decorator(ICar car) {
        this.car = car;
    }
    @Override
    public void run() {
        car.run();
    }
}
//ConcreteDecorator具体装饰角色
class FlyCar extends Decorator {
    public FlyCar(ICar car) {
        super(car);
    }
    private void fly(){
        System.out.println("天上飞");
    }
    @Override
    public void run() {
        super.run();
        this.fly();
    }
}
//ConcreteDecorator具体装饰角色
class WaterCar extends Decorator {
    public WaterCar(ICar car) {
        super(car);
    }
    private void swim(){
        System.out.println("水里游");
    }
    @Override
    public void run() {
        super.run();
        this.swim();
    }
}


