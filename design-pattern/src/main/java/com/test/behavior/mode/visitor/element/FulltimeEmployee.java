package com.test.behavior.mode.visitor.element;

import com.test.behavior.mode.visitor.visitor.Department;

/**
 * 全职员工类：具体元素类
 */
public class FulltimeEmployee implements Employee{

    private String name;
    private double weeklyWage;
    private int workTime;

    public FulltimeEmployee(String name, double weeklyWage, int workTime) {
        this.name = name;
        this.weeklyWage = weeklyWage;
        this.workTime = workTime;
    }

    /**
     * 	调用访问者的访问方法
     */
    @Override
    public void accept(Department department) {
        department.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeeklyWage() {
        return weeklyWage;
    }

    public void setWeeklyWage(double weeklyWage) {
        this.weeklyWage = weeklyWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}
