package com.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesParser {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesParser.class);

    Properties properties;

    public PropertiesParser(String propPath) {
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
        return properties.getProperty(key);
    }
}
