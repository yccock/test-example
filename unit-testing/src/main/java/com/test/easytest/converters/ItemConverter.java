package com.test.easytest.converters;

import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class ItemConverter extends AbstractConverter<Item>{
    @Override
    public Item convert(Map<String, Object> map) {
        Item item = null;
        if (map != null) {
            item = new Item();
            item.setName((String) map.get("name"));
            item.setAge(Integer.parseInt(map.get("age").toString()));
            item.setExpectedOutput((String) map.get("expectedOutput"));
        }
        return item;
    }
}
