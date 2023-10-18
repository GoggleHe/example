package org.example.unittest.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.jupiter.api.extension.TestInstanceFactory;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

public class MyInvocationInterceptor implements InvocationInterceptor {
    @Override
    public void interceptTestMethod(Invocation<Void> invocation,
                                    ReflectiveInvocationContext<Method> invocationContext,
                                    ExtensionContext extensionContext) throws Throwable {

        AtomicReference<Throwable> throwable = new AtomicReference<>();

        SwingUtilities.invokeAndWait(() -> {
            try {
                invocation.proceed();
            }
            catch (Throwable t) {
                throwable.set(t);
            }
        });
        Throwable t = throwable.get();
        if (t != null) {
            throw t;
        }
    }
}
