package com.test.maven.embedder;

public class TestExecMavenCmd {

    public static void main(String[] args) {

        ExecMavenCmd execMavenCmd = new ExecMavenCmd();
        String[] cmds = new String[]{
                "-f",
                "D:\\lib\\pom.xml",
                "dependency:copy-dependencies",
                "-DoutputDirectory=./lib"
        };

        String[] cmds2 = new String[]{
                "-X",
                "-f",
                "D:\\lib\\pom.xml",
                "dependency:build-classpath",
                "-Dmdep.pathSeparator=\";\""
        };
        ExecMavenCmd.Result exec = execMavenCmd.exec(cmds);
        String result = exec.getResult();
        System.out.println(result);
        System.out.println(result.indexOf("ExecutionEventLogger - BUILD SUCCESS"));
    }
}
