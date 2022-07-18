package com.clipboard.controller;

import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.PrintStream;
import java.util.Objects;

/**
 * @author jitendra.pisal
 */
public class ScenarioController {

    private static Scenario scenario;
    private static int totalNumberOfScenarios = 0;
    private static int executedScenarioCount = 0;
    private static int failedScenarioCount = 0;
    static Logger logger = Logger.getLogger(ScenarioController.class);

    public ScenarioController() {
    }

    static void setScenario(Scenario scenario) {
        ScenarioController.scenario = scenario;
        if (totalNumberOfScenarios == 0) {
            setTotalNumberOfScenarios();
        }

        ++executedScenarioCount;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static int getExecutedScenarioCount() {
        return executedScenarioCount;
    }

    static void printInitialLogs() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("************************** Running Now **************************************");
        System.out.println("--------------------------------------------------------------------------------");
        PrintStream var10000 = System.out;
        int var10001 = getExecutedScenarioCount();
        var10000.println("Scenario Number in Current Execution: " + var10001 + " / " + totalNumberOfScenarios);
        System.out.println("Scenario Name: " + getScenario().getName());
        System.out.println("Scenario Tags: " + getScenario().getSourceTagNames());
        System.out.println("--------------------------------------------------------------------------------");
    }


    static void setTotalNumberOfScenarios() {
        try {
            totalNumberOfScenarios = ((String[]) Objects.requireNonNull((new File(System.getProperty("user.dir") + "/target/parallel/features")).list())).length;
        } catch (NullPointerException var1) {
            logger.error("The directory '" + System.getProperty("user.dir") + "/target/parallel/features' was not found, or is not a directory.");
        }
    }

    static void printFinalLogs() {
        if (scenario.isFailed()) {
            ++failedScenarioCount;
        }

        System.out.println();
        System.out.println("***** Scenario Result Analysis *********");
        int var10002 = executedScenarioCount - failedScenarioCount;
        System.out.println("                          Successful / Failed / Total scenarios: " + var10002 + " / " + failedScenarioCount + " / " + totalNumberOfScenarios);
        System.out.println();
    }
}
