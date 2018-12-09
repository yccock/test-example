package com.test.create.mode.factory._3abstractFactory.client;

import com.test.create.mode.factory._3abstractFactory.button.Button;
import com.test.create.mode.factory._3abstractFactory.combobox.ComboBox;
import com.test.create.mode.factory._3abstractFactory.factory.SkinFactory;
import com.test.create.mode.factory._3abstractFactory.factory.SpringSkinFactory;
import com.test.create.mode.factory._3abstractFactory.text.TextField;

public class Client {

    public static void main(String[] args) {
        SkinFactory springSkinFactory = new SpringSkinFactory();
        Button springButton = springSkinFactory.createButton();
        TextField springTextField = springSkinFactory.createTextField();
        ComboBox springComboBox = springSkinFactory.createComboBox();
        springButton.display();
        springTextField.display();
        springComboBox.display();

        SkinFactory summarySkinFactory = new SpringSkinFactory();
        Button summaryButton = summarySkinFactory.createButton();
        TextField summaryTextField = summarySkinFactory.createTextField();
        ComboBox summaryComboBox = summarySkinFactory.createComboBox();
        summaryButton.display();
        summaryTextField.display();
        summaryComboBox.display();

    }
}
