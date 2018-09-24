package com.test.classloader.hotswap;

import java.net.URL;
import java.net.URLClassLoader;

public class HostSwapClassLoader extends URLClassLoader {


    public HostSwapClassLoader(URL[] urls) {
        super(urls);
    }
}
