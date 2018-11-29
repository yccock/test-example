package com.test.easytest.json;

import com.test.easytest.converters.Item;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths= "params/jsonData.xls")
public class TestJsonDataDriver {

    @Test
    public void getJSONObject(@Param(name="Item")Item item ){
        System.out.println("==========" + item);
    }
}
