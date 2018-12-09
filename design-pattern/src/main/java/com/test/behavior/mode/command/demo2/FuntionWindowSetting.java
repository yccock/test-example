package com.test.behavior.mode.command.demo2;

import com.test.behavior.mode.command.demo2.invoker.FuntionButton;

import java.util.ArrayList;

/**
 * 功能键设置窗口类
 */
public class FuntionWindowSetting {

    private	String	title;	//窗口标题
    private ArrayList<FuntionButton> functionButtons = new ArrayList<>(); //定义一个ArrayList来存储所有功能键

    public FuntionWindowSetting(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addFuntionButton(FuntionButton funtionButton) {
        functionButtons.add(funtionButton);
    }

    public void removeFuntionButton(FuntionButton funtionButton) {
        functionButtons.remove(funtionButton);
    }

    //显示窗口及功能键
    public void display() {
        System.out.println("显示窗口标题：" + this.title);
        System.out.println("显示功能键：");
        for (FuntionButton functionButton : functionButtons) {
            System.out.println(functionButton.getName());
        }
        System.out.println("--------------------------------");
    }
}
