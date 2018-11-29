package com.test.easytest.config;

import org.easetech.easytest.annotation.TestBean;

public class ConfigProviderClass {

    @TestBean("itemService") public ItemService itemService(){
        return new ItemService();
    }

}
