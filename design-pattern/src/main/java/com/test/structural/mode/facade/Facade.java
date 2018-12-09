package com.test.structural.mode.facade;

import com.test.structural.mode.facade.subsystem.Drugstore;
import com.test.structural.mode.facade.subsystem.Payment;
import com.test.structural.mode.facade.subsystem.Register;
import com.test.structural.mode.facade.subsystem.TreatMent;

/**
 * 门面类，相当于医院的接待处
 */
public class Facade {

    private Register register;
    private TreatMent treatMent;
    private Payment payment;
    private Drugstore drugstore;

    public Facade() {
        register = new Register();
        treatMent = new TreatMent();
        payment = new Payment();
        drugstore = new Drugstore();
    }

    public void process(){
        //接待处挂号
        register.register();
        //门诊
        treatMent.treat();
        //接待处缴费
        payment.pay();
        //接待处取药
        drugstore.getDrug();
    }
}
