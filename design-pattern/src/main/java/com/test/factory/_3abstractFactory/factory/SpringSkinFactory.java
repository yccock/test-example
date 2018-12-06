package com.test.factory._3abstractFactory.factory;

import com.test.factory._3abstractFactory.button.Button;
import com.test.factory._3abstractFactory.button.SrpingButton;
import com.test.factory._3abstractFactory.combobox.ComboBox;
import com.test.factory._3abstractFactory.combobox.SpringComboBox;
import com.test.factory._3abstractFactory.text.SpringTextField;
import com.test.factory._3abstractFactory.text.TextField;

/**
 * Spring皮肤工厂：具体工厂
 */
public class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SrpingButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
