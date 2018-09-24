package com.test;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class JavaTestClient extends AbstractJavaSamplerClient{

    private String LABEL = "测试方法标签";

    @Override
    public void setupTest(JavaSamplerContext context) {
        //聚合报告界面显示
        new SampleResult().setSampleLabel(LABEL);
    }

    @Override
    public void teardownTest(JavaSamplerContext context) {
        super.teardownTest(context);
    }

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        //从jmeter界面中获取的参数
        String username = context.getParameter("username");
        String password = context.getParameter("password");

        SampleResult result = new SampleResult();
        try {
            result.sampleStart();   //记录程序执行时间，以及执行结果
            System.out.println("username: " + username + " >>>>>  password: " + password);
            result.setSuccessful(true);
            result.setResponseData("返回成功", "utf-8");
            result.setResponseCodeOK();
            result.setSamplerData("result");
        } catch (Exception e) {
            result.setSuccessful(false);
            e.printStackTrace();
        } finally {
            result.sampleEnd();
        }
        return result;
    }

    //设置传入的参数，可以设置多个，已设置的参数会显示到Jmeter界面的参数列表中
    @Override
    public Arguments getDefaultParameters() {
        Arguments arg = new Arguments();
        arg.addArgument("id","1");
        arg.addArgument("username","");
        arg.addArgument("password","");
        return arg;
    }

    public static void main(String[] args) {
        Arguments arguments = new Arguments();
        arguments.addArgument("id", "1");
        arguments.addArgument("username", "test");
        arguments.addArgument("password", "123456");
        JavaSamplerContext context = new JavaSamplerContext(arguments);
        JavaTestClient javaTestClient = new JavaTestClient();
        javaTestClient.setupTest(context);
        javaTestClient.runTest(context);
    }
}
