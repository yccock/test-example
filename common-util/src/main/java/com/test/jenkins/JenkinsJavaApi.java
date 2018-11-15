package com.test.jenkins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class JenkinsJavaApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(JenkinsJavaApi.class);

    public static final String SERVER_URL = "http://192.168.202.132/jenkins";
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "12345";

    private static JenkinsServer jenkinsServer;

    static{
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

    public static Map<String, Job> getJobs(){
        Map<String, Job> jobs = null;
        try {
            jobs = jenkinsServer.getJobs();
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

    public static void main(String[] args)  {
        JenkinsJavaApi.getJobs();
    }
}
