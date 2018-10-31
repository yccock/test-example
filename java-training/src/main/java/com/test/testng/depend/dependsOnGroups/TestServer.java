package com.test.testng.depend.dependsOnGroups;

import org.testng.annotations.Test;

@Test(groups = "deploy")
public class TestServer {

    @Test
    public void deployServer() {
        System.out.println("Deploying Server...");
    }

    // Run this if deployServer() is passed.
    @Test(dependsOnMethods = "deployServer")
    public void deployBackUpServer() {
        System.out.println("Deploying Backup Server...");
    }
}
