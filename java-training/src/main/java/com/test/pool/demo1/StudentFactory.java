package com.test.pool.demo1;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 为了使用common-pool2对象池管理，我们必须实现PooledObjectFactory或者其子类
 * 这是一个工厂模式，告诉对象池怎样去创建要管理的对象
 */
public class StudentFactory extends BasePooledObjectFactory<Student> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentFactory.class);
    /**
     * 表明怎样创建需要管理对象
     * @return
     * @throws Exception
     */
    @Override
    public Student create() throws Exception {
        return new Student("张三", 18);
    }

    /**
     * 在common-pool2中为了统计管理的对象的一些信息，比如调用次数，空闲时间，上次使用时间等，
     * 需要对管理的对象进行包装，然后在放入到对象池中
     * @param student
     * @return
     */
    @Override
    public PooledObject<Student> wrap(Student student) {
        return new DefaultPooledObject<>(student);
    }


    @Override
    public PooledObject<Student> makeObject() throws Exception {
        LOGGER.info("make Object");
        return super.makeObject();
    }

    @Override
    public void destroyObject(PooledObject<Student> p) throws Exception {
        LOGGER.info("destroy Object");
        Student student = p.getObject();
        student = null;
        super.destroyObject(p);
    }

    /**
     * 功能描述：判断资源对象是否有效，有效返回 true，无效返回 false
     *
     * 什么时候会调用此方法
     * 1：从资源池中获取资源的时候，参数 testOnBorrow 或者 testOnCreate 中有一个 配置 为 true 时，
     *    则调用  factory.validateObject() 方法
     * 2：将资源返还给资源池的时候，参数 testOnReturn，配置为 true 时，调用此方法
     * 3：资源回收线程，回收资源的时候，参数 testWhileIdle，配置为 true 时，调用此方法
     */
    @Override
    public boolean validateObject(PooledObject<Student> p) {
        LOGGER.info("validate Object");
        return super.validateObject(p);
    }

    /**
     *  什么时候会调用此方法
     * 1：从资源池中获取资源的时候
     * 2：资源回收线程，回收资源的时候，根据配置的 testWhileIdle 参数，判断 是否执行 factory.activateObject()方法，
     *    true 执行，false 不执行
     * @param p
     * @throws Exception
     */
    @Override
    public void activateObject(PooledObject<Student> p) throws Exception {
        LOGGER.info("activate Object");
        super.activateObject(p);
    }

    /**
     * 功能描述：钝化资源对象
     *
     * 什么时候会调用此方法
     * 1：将资源返还给资源池时，调用此方法。
     */
    @Override
    public void passivateObject(PooledObject<Student> p) throws Exception {
        LOGGER.info("passivate Object");
        super.passivateObject(p);
    }
}
