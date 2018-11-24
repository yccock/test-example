package com.test.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class JenkinsJavaApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(JenkinsJavaApi.class);

    // public static final String SERVER_URL = "http://192.168.202.132/jenkins";
    public static final String SERVER_URL = "http://192.168.171.197:8090";

    public static final String USERNAME = "admin";
    public static final String PASSWORD = "JD0832@b1";

    private static JenkinsServer jenkinsServer;

    static {
        try {
            jenkinsServer = new JenkinsServer(new URI(SERVER_URL), USERNAME, PASSWORD);
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static boolean createJob(String jobName, String jobXml) {
        try {
            jenkinsServer.createJob(jobName, jobXml);
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    public static boolean updateJob(String jobName, String jobXml) {
        try {
            jenkinsServer.updateJob(jobName, jobXml);
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    public static boolean deleteJob(String jobName) {
        try {
            jenkinsServer.deleteJob(jobName);
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * 获取所有任务
     * @return
     */
    public static Map<String, Job> getJobs() {
        Map<String, Job> jobs = null;
        try {
            jobs = jenkinsServer.getJobs();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return jobs;
    }

    /**
     * 获取某一个tab下的所有任务
     * @param viewName
     * @return
     */
    public static Map<String, Job> getViewJobs(String viewName) {
        Map<String, Job> jobs = null;
        try {
            jobs = jenkinsServer.getJobs(viewName);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return jobs;
    }

    public static JobWithDetails getJobDetail(String jobName) {
        JobWithDetails jobWithDetails = null;
        try {
            jobWithDetails = jenkinsServer.getJob(jobName);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return jobWithDetails;
    }

    /**
     * 获取job的config.xml内容
     *
     * @param jobName
     * @return
     */
    public static String getJobXml(String jobName) {
        String jobXml = null;
        try {
            jobXml = jenkinsServer.getJobXml(jobName);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return jobXml;
    }

    public static boolean buildJobWithParameters(String jobName, Map<String, String> params) {
        try {
            JobWithDetails jobWithDetails = jenkinsServer.getJob(jobName);
            jobWithDetails.build(params);
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }
    public static void updateJob(String url, String jobName, String gitAddress, String branch) throws Exception {
        try {
            String jobXml = jenkinsServer.getJobXml(jobName);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new ByteArrayInputStream(jobXml.getBytes("utf-8")));
            Element rootElement = document.getRootElement();
            if (StringUtils.isNotBlank(gitAddress)) {
                Element gitUrlElement = rootElement.element("scm").element("userRemoteConfigs").element("hudson.plugins.git.UserRemoteConfig").element("url");
                gitUrlElement.setText(gitAddress);
            }
            if (StringUtils.isNotBlank(branch)) {
                Element branchElement = rootElement.element("properties").element("hudson.model.ParametersDefinitionProperty")
                        .element("parameterDefinitions");
                List elements = branchElement.elements();
                for (Object object : elements) {
                    Element el = (Element) object;
                    String name = el.element("name").getText();
                    if (name.equals("branch")) {
                        el.element("defaultValue").setText(branch);
                    }
                }
            }
            jenkinsServer.updateJob(jobName, document.asXML());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("更新jenkins job失败:" + e.getMessage());
        }
    }

}
