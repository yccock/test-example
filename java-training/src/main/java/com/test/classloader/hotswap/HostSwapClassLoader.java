package com.test.classloader.hotswap;

import java.net.URL;
import java.net.URLClassLoader;

//https://my.oschina.net/ososchina/blog/1599977
//https://www.ibm.com/developerworks/cn/java/j-lo-hotswapcls/index.html
//https://my.oschina.net/ososchina/blog/1599977

public class HostSwapClassLoader extends URLClassLoader {

    public HostSwapClassLoader(URL[] urls) {
        super(urls);
    }
}
