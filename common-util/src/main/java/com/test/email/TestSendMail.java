package com.test.email;

public class TestSendMail {

    public static void main(String[] args) {
        String subject = "test";
        String content = "test content <br><a href='http://test.com'>查看详情</a>";
        String toAddress = "123@qq.com";
        String ccAddresses = "";
        MailSender.send(toAddress, ccAddresses, subject, content);
    }
}
