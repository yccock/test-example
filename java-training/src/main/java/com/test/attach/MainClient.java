package com.test.attach;


import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * http://ju.outofmemory.cn/entry/227669
 * 动态修改JVM的字节码
 */
public class MainClient {

    public static void attach(String pid, String agentPath) throws Exception {
        try {
            //attach到远程JVM上去
            VirtualMachine  vm = VirtualMachine.attach(pid);
            //加载agent
            vm.loadAgent(agentPath);
        } catch (RuntimeException re) {
            throw re;
        } catch (IOException ioexp) {
            throw ioexp;
        } catch (Exception exp) {
            exp.printStackTrace();
            throw exp;
        }
    }

    /**
     * 如果你不想把tools.jar打包的client中，你需要在运行client JAR的时候带上tools.jar.
     * java -Xbootclasspath/a:tools.jar  -jar /home/xxx/MainClient-1.0-SNAPSHOT.jar 进程PID /home/xxx/agent-1.0.0.jar
     *
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("[usage:java -jar client-1.0.0.jar pid path] and args.lenght="+args.length);
            return;
        }
        // 第0个参数是要attach的JVM进程ID
        String pid = args[0];
        // 第1个参数是agent JAR包所在的路径
        String agentPath =args[1];
        System.out.println("pid:" + pid);
        System.out.println("agentPath:" + agentPath);
        try {
            attach(pid, agentPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
