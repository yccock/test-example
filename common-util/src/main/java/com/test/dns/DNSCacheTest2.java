package com.test.dns;

import com.alibaba.dcm.DnsCacheManipulator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSCacheTest2 {

    /**
     * 注：
     * dns-cache.properties是缺省文件名，可以通过JVM的-D选项dcm.config.filename修改使用的配置文件名，如
     * -Ddcm.config.filename=my-dns-cache.properties。
     */
    @BeforeClass
    public static void loadDns(){
        //批量导入dns-cache.properties中的dns
        DnsCacheManipulator.loadDnsCacheConfig();
    }

    @Test
    public void test() throws UnknownHostException {
        System.out.println(InetAddress.getByName("www.foo.com").getHostAddress());
    }
}
