package com.test.shell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ProcessUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessUtil.class);

    private static final String SEPARATOR = System.getProperty("line.separator");

    public static String exec(String[] cmds) {
        List<String> commands = Arrays.asList(cmds);
        BufferedReader br = null;
        Process process = null;
        StringBuilder sb = new StringBuilder();
        try {
            ProcessBuilder builder = new ProcessBuilder(commands);
            builder.redirectErrorStream(true);
            process = builder.start();
            br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(SEPARATOR);
            }
            process.waitFor();
            int exitValue = process.exitValue();
            if (exitValue != 0) {
                LOGGER.error(String.format("failed to execute: {}, exitCode: {}", builder.command(), exitValue));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (process != null) {
                process.destroy();
            }
        }
        return sb.toString();
    }
}
