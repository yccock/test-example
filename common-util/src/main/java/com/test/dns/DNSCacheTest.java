package com.test.dns;

import com.alibaba.dcm.DnsCache;
import com.alibaba.dcm.DnsCacheManipulator;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSCacheTest {

    public static void main(String[] args) throws UnknownHostException {
        DnsCacheManipulator.setDnsCache("www.hello.com", "192.168.1.1");
        DnsCacheManipulator.setDnsCache("www.world.com", "1234:5678:0:0:0:0:0:200e"); // 支持IPv6地址

        // 上面设置全局生效，之后Java中的所有的域名解析逻辑都会是上面设定的IP。
        // 下面用一个简单获取域名对应的IP，来演示一下：

        String ip = InetAddress.getByName("www.hello.com").getHostAddress();
        // ip = "192.168.1.1"
        String ipv6 = InetAddress.getByName("www.world.com").getHostAddress();
        // ipv6 = "1234:5678:0:0:0:0:0:200e"

        // 可以设置多个IP
        DnsCacheManipulator.setDnsCache("www.hello-world.com", "192.168.2.1", "192.168.2.2");

        String ipHw = InetAddress.getByName("www.hello-world.com").getHostAddress();
        // ipHw = 192.168.2.1 ，读到第一个IP
        InetAddress[] allIps = InetAddress.getAllByName("www.hello-world.com");
        // 上面读到设置的多个IP

        // 设置失效时间，单元毫秒
        DnsCacheManipulator.setDnsCache(3600 * 1000, "www.hello-hell.com", "192.168.1.1", "192.168.1.2");

        //查看JVM DNS Cache
        DnsCache dnsCache = DnsCacheManipulator.getWholeDnsCache();
        System.out.println(dnsCache);

        // 查看缓存时间，单位秒。-1表示永远缓存，0表示不缓存
        int cachePolicy = DnsCacheManipulator.getDnsCachePolicy();
        // 设置缓存时间
        DnsCacheManipulator.setDnsCachePolicy(2);

        // 查看未命中条目的缓存时间
        DnsCacheManipulator.getDnsNegativeCachePolicy();
        // 设置未命中条目的缓存时间
        DnsCacheManipulator.setDnsNegativeCachePolicy(0);

        //清空JVM DNS Cache
        DnsCacheManipulator.clearDnsCache();

        //删除一条DNS Cache
        DnsCacheManipulator.removeDnsCache("www.hello-world.com");
    }
}
