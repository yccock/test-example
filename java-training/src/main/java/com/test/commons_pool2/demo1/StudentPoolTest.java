package com.test.commons_pool2.demo1;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//https://blog.csdn.net/amon1991/article/details/77427236

public class StudentPoolTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentPoolTest.class);

    public static void main(String[] args) throws Exception {
        //资源池配置
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMinIdle(5);
        config.setTestOnBorrow(true);

        //工厂
        StudentFactory factory = new StudentFactory();

        GenericObjectPool<Student> objectPool = new GenericObjectPool(factory, config);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            //获取资源对象
            Student student = objectPool.borrowObject();
            //将获取的资源对象，返还给资源池
            objectPool.returnObject(student);
            LOGGER.info(student.toString());
        }

    }
}
