// Task003: Test launcher

package org.example;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestLauncher {

    public static void main(String[] args) {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(TestCases.class))
                .build());
        System.out.println("Total test cases: "+listener.getSummary().getTestsFoundCount());
        System.out.println("Test cases passed: "+listener.getSummary().getTestsSucceededCount());
        System.out.println("Test cases failed: "+listener.getSummary().getTestsFailedCount());
    }
}