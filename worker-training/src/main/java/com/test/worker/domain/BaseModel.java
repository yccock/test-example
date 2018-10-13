package com.test.worker.domain;

import java.io.Serializable;

public class BaseModel implements Serializable {

    public static final long serialVersionUID = 1L;

    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
