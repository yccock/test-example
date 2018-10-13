package com.test.worker.task;

import com.test.worker.domain.BaseModel;

public abstract class Task<T extends BaseModel> implements Runnable {

    protected T t;

    public Task(T t) {
        this.t = t;
    }

    public abstract void startTask();

    public abstract void stopTask();

    public void run() {
        startTask();
    }

    public String getTaskUuid(){
        return String.format("%s-%s", this.t.getClass().getSimpleName(), this.t.getId());
    }
}
