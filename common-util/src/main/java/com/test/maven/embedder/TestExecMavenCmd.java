package com.test.maven.embedder;

public class TestExecMavenCmd {

    public static void main(String[] args) {

        ExecMavenCmd execMavenCmd = new ExecMavenCmd();
//        String[] cmds = new String[]{
//                "-X",
//                "-f",
//                "D:\\lib\\pom.xml",
//                "dependency:copy-dependencies",
//                "-DoutputDirectory=./lib"
//        };
//        ExecMavenCmd.Result exec = execMavenCmd.exec(cmds);
//        String result = exec.getResult();
//        System.out.println(result);

        String[] cmds2 = new String[]{
                "-f",
                "D:\\lib\\pom.xml",
                "dependency:build-classpath",
                "-Dmdep.pathSeparator=\";\""
        };
        ExecMavenCmd.Result exec2 = execMavenCmd.exec(cmds2);
        String result2 = exec2.getResult();
        String[] lines = result2.split(System.lineSeparator());
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println(result2.indexOf("ExecutionEventLogger - BUILD SUCCESS"));
    }
}
