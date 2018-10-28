package com.test.jsch;

import com.alibaba.fastjson.JSON;
import com.jcraft.jsch.*;
import com.test.properties.PropertiesWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//http://www.jcraft.com/jsch/examples/
//https://blog.csdn.net/coding99/article/details/52416373
public class JschUtil {

    private static final Logger logger = LoggerFactory.getLogger(JschUtil.class);

    private static int TIMEOUT = 1000;

    private static PropertiesWrap getProperties() {
        PropertiesWrap propertiesWrap = new PropertiesWrap("jsch.properties");
        return propertiesWrap;
    }

    private static Session getConnect(String host, int port, String username,
                                      String password, String cmd){
        JSch jSch = new JSch();
        Session session = null;
        try {
            session = jSch.getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("PreferredAuthentications", "password");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect(1 * TIMEOUT);
        } catch (JSchException e) {
            logger.error("host:{}, ip:{} 连接失败", host, port, e);
        }
        return session;
    }

    public static List<String> exeCmd(String host, int port, String username, String password,
                              String cmd) throws JSchException {
        Session session = null;
        Channel channel = null;
        List<String> result = new ArrayList<>();
        try {
            session = getConnect(host, port, username, password, cmd);
            if (!session.isConnected()) {
                return result;
            }
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(cmd);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream in = channel.getInputStream();
            channel.connect(1 * TIMEOUT);
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    result.add(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) {
                        continue;
                    }
                    result.add("exit-status: " + channel.getExitStatus());
                    break;
                }
                if (channel.getExitStatus() != 0) {
                    logger.error("执行命令结果：{},命令：{}", JSON.toJSONString(result), cmd);
                    logger.error("exit-status: " + channel.getExitStatus());
                }
            }
        } catch (IOException e) {
            logger.error("执行命令异常，异常信息：", e);
        } finally {
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
        return result;
    }

    public static void main(String[] args) throws JSchException {
        PropertiesWrap properties = getProperties();
        String host = properties.getStringProperty("jsch.host");
        Integer port = properties.getIntegerProperty("jsch.port");
        String username = properties.getStringProperty("jsch.username");
        String password = properties.getStringProperty("jsch.password");
        Integer timeout = properties.getIntegerProperty("jsch.connect.timeout");
        List<String> result = exeCmd(host, port, username, password, "cd /export;ls");
        System.out.println(result);
    }
}
