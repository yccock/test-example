package com.test.factory._3abstractFactory.factory;

import com.test.factory._3abstractFactory.button.Button;
import com.test.factory._3abstractFactory.combobox.ComboBox;
import com.test.factory._3abstractFactory.text.TextField;

/**
 * 界面皮肤工厂接口：抽象工厂
 */
public interface SkinFactory {

    Button createButton();

    TextField createTextField();

    ComboBox createComboBox();
}
