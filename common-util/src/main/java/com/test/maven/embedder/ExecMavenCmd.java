package com.test.maven.embedder;

import org.apache.maven.cli.MavenCli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class ExecMavenCmd {

    private static final Logger logger = LoggerFactory.getLogger(ExecMavenCmd.class);

    private static final String LOCAL_REPO = "D:\\MavenRepository";

    public Result exec(String[] cmds){
        Result result = new Result();
        String workDirectory = System.getProperty("user.home");
        System.setProperty(MavenCli.MULTIMODULE_PROJECT_DIRECTORY, workDirectory);
        System.setProperty(MavenCli.LOCAL_REPO_PROPERTY, LOCAL_REPO);

        ByteArrayOutputStream baosOut = new ByteArrayOutputStream();
        ByteArrayOutputStream baosErr = new ByteArrayOutputStream();
        PrintStream stdStream = new PrintStream(baosOut, true);
        PrintStream errStream = new PrintStream(baosErr, true);
        try {
            MavenCli mavenCli = new MavenCli();
            int resultCode = mavenCli.doMain(cmds, workDirectory, stdStream, errStream);
            String stdout = baosOut.toString("UTF-8");
            result.setResult(stdout);
            if (resultCode == 0) {
                result.setSuccess(true);
            } else {
                String stderr = baosErr.toString("UTF-8");
                logger.error("exe maven cmd failed: mvn {}, stdout:{}, stderr:{}",
                        String.join(" ", cmds), stdout, stderr);
            }
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        errStream.close();
        stdStream.close();
        return result;
    }

    class Result{

        private boolean success = false;

        private String result;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
