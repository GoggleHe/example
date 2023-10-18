package org.example.unittest.extension;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private long startTime;

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Test took " + duration + "ms");
    }
}
