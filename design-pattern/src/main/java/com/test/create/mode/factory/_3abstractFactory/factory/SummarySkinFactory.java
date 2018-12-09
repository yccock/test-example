package com.test.create.mode.factory._3abstractFactory.factory;

import com.test.create.mode.factory._3abstractFactory.button.Button;
import com.test.create.mode.factory._3abstractFactory.button.SummaryButton;
import com.test.create.mode.factory._3abstractFactory.combobox.ComboBox;
import com.test.create.mode.factory._3abstractFactory.combobox.SummaryComboBox;
import com.test.create.mode.factory._3abstractFactory.text.SummaryTextField;
import com.test.create.mode.factory._3abstractFactory.text.TextField;

/**
 * Spring皮肤工厂：具体工厂
 */
public class SummarySkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SummaryButton();
    }

    @Override
    public TextField createTextField() {
        return new SummaryTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummaryComboBox();
    }
}
