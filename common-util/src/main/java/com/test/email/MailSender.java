package com.test.email;

import com.test.properties.PropertiesWrap;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {

    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    private static PropertiesWrap prop = new PropertiesWrap("email.properties");

    private static void sendEmail(String toAddress, String ccAddresses, String subject, String content) {
        HtmlEmail htmlEmail = new HtmlEmail();
        try {
            //发送人
            htmlEmail.setFrom(prop.getStringProperty("mail.send.fromAddress"));
            htmlEmail.setSocketConnectionTimeout(prop.getIntegerProperty("mail.smtp.timeout"));
            //密码校验
            htmlEmail.setAuthentication(prop.getStringProperty("mail.send.username"),
                    prop.getStringProperty("mail.send.password"));
            //发送服务器地址
            htmlEmail.setHostName(prop.getStringProperty("mail.smtp.host"));
            htmlEmail.setSmtpPort(prop.getIntegerProperty("mail.smtp.port"));
            //ssl
            boolean sslOnConnect = prop.getBooleanProperty("mail.smtp.ssl.enable");
            if (sslOnConnect) {
                htmlEmail.setSSLOnConnect(sslOnConnect);
                htmlEmail.setSslSmtpPort(prop.getStringProperty("mail.smtp.ssl.port"));
            }
            //接收人
            htmlEmail.addTo(toAddress);
            //抄送人
            if (ccAddresses != null && ccAddresses.length() > 0) {
                for (String cc : ccAddresses.split(";")) {
                    if (cc == null || cc.length() == 0) continue;
                    htmlEmail.addCc(cc);
                }
            }
            //邮件编码
            htmlEmail.setCharset("utf-8");
            //邮件内容
            htmlEmail.setMsg(content);
            //邮件title
            htmlEmail.setSubject(subject);
            htmlEmail.send();
        } catch (EmailException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    public static void send(String toAddress, String ccAddresses, String subject, String content){
//        new Thread(() -> sendEmail(toAddress, ccAddresses, subject, content));
        sendEmail(toAddress, ccAddresses, subject, content);
    }
}
