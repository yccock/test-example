package com.test.behavior.mode.chain.handler;

import com.test.behavior.mode.chain.LeaveRequest;

/**
 * 领导的抽象类
 */
public abstract class Leader {

    protected String name;

    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    // 设定责任链上的后继对象
    public void setNextLeader(Leader nextLeader){
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求的核心的业务方法
     * 需要不同继承该类的领导自己实现
     */
    public abstract void handleRequest(LeaveRequest leaveRequest);
}
