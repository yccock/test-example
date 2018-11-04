package com.test.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesWrap {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesWrap.class);

    private Properties properties;

    public PropertiesWrap(String propPath) {
        try {
            this.load(propPath);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void load(String propPath) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propPath);
        this.properties = new Properties();
        this.properties.load(inputStream);
    }

    public String getStringProperty(String key){
        return this.properties.getProperty(key);
    }

    public Integer getIntegerProperty(String key){
        String property = this.properties.getProperty(key);
        return property == null ? 0 : Integer.parseInt(property);
    }

    public boolean getBooleanProperty(String key){
        String property = this.properties.getProperty(key);
        return property == null ? false :Boolean.parseBoolean(property);
    }
}
