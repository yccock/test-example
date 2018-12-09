package com.test.structural.mode.proxy.staticProxy.proxy;

import com.test.structural.mode.proxy.staticProxy.extend.AccessValidator;
import com.test.structural.mode.proxy.staticProxy.extend.Logger;
import com.test.structural.mode.proxy.staticProxy.service.ISearcher;
import com.test.structural.mode.proxy.staticProxy.service.RealSearcher;

/**
 * 代理查询类，充当代理主题角色，它是查询代理
 */
public class ProxySearcher implements ISearcher {

    private ISearcher searcher = new RealSearcher();
    private AccessValidator accessValidator = new AccessValidator();
    private Logger logger = new Logger();

    @Override
    public String doSearch(String userId, String keyword) {
        if (this.validate(userId)) {
            String result = searcher.doSearch(userId, keyword);
            this.log(userId);
            return result;
        }
        return null;
    }

    //创建访问验证对象并调用其validate()方法实现身份验证
    public boolean validate(String userId) {
        return accessValidator.Validate(userId);
    }

    //创建日志记录对象并调用其Log()方法实现日志记录
    public void log(String userId) {
        logger.writeLog(userId);
    }
}
