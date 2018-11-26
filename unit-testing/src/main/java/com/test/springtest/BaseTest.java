package com.test.springtest;

// https://my.oschina.net/luanwu/blog/1594565
// https://www.ibm.com/developerworks/cn/java/j-lo-springunitest/index.html

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
@Transactional
public class BaseTest extends AbstractJUnit4SpringContextTests{


}
