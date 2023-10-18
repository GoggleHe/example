package org.example.unittest.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class MyTestWatcher implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("testDisabled");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("testSuccessful");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("testAborted");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("testFailed");
    }
}
