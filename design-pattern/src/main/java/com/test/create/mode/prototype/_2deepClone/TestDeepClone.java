package com.test.create.mode.prototype._2deepClone;

import java.io.IOException;
import java.util.Date;


/**
 * 深复制测试
 */
public class TestDeepClone {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Date date = new Date(2313111231L);
        Attachment attachment = new Attachment();
        WeeklyLog logOld = new WeeklyLog();
        logOld.setName("第16周");
        logOld.setDate(date);
        logOld.setAttachment(attachment);

        WeeklyLog logNew = logOld.deepClone();
        //浅复制时修改对象属性会影响复制的对象属性
        date.setTime(1234567L);

        System.out.println(logOld);
        System.out.println(logNew);
        System.out.println("周报是否相同：" + (logOld == logNew));
        System.out.println("附件是否相同：" + (logOld.getAttachment() == logNew.getAttachment()));
    }
}
