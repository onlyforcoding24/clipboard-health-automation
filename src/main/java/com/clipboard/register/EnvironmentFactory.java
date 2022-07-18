package com.clipboard.register;

import java.io.IOException;

/**
 * @author jitendra.pisal
 */
public class EnvironmentFactory {

    private static String device;
    private static String hub;
    private static String environmentUrl;
    private static String environmentName;
    private static String projectName;
    private static String projectPath;
    private static int waitTime;

    public static String getDevice() {
        if (device == null) {
            device = System.getProperty("device") != null ? System.getProperty("device") : "chrome";
        }
        return device;
    }

    public static int getWaitTime() {
        if (waitTime == 0) {
            waitTime = System.getProperty("waitTime") != null ? Integer.parseInt(System.getProperty("waitTime"))
                    : I.amPerforming().waitFor().getStandardWaitTime();
        }
        return waitTime;
    }

    public static String getHub() {
        if (hub == null) {
            hub = System.getProperty("hub") != null ? System.getProperty("hub") : "local";
        }
        return hub;
    }

    public static String getEnvironmentUrl() {
        if (environmentUrl == null) {
            try {
                environmentUrl = I.amPerforming().propertiesFileOperationsTo().readPropertyFile("environment.properties", getEnvironmentName());
            } catch (IOException var1) {
                var1.printStackTrace();
            }
        }
        return environmentUrl;
    }

    public static String getEnvironmentName() {
        if (environmentName == null) {
            environmentName = System.getProperty("env") != null ? System.getProperty("env").toUpperCase() : "QA";
        }
        return environmentName;
    }

    public static void setProjectName(String projectName) {
        EnvironmentFactory.projectName = projectName;
    }

    public static void setProjectPath(String projectPath) {
        EnvironmentFactory.projectPath = projectPath;
    }

    public static String getProjectPath() {
        return projectPath == null ? "" : projectPath;
    }

    public static String getProjectName() {
        return projectName == null ? "" : projectName;
    }
}
