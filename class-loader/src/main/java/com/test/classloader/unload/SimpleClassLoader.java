package com.test.classloader.unload;

import java.net.URL;
import java.net.URLClassLoader;

public class SimpleClassLoader extends URLClassLoader{

    public SimpleClassLoader(URL[] urls) {
        super(urls);
    }
}
