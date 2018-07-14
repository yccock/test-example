package com.test;

import javax.jws.WebService;

@WebService
public interface HelloService {

    public String sayHello(String keyword);

}
