package org.example.unittest.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestInstancePreConstructCallback;

public class MyTestInstancePreConstructCallback implements TestInstancePreConstructCallback {

    @Override
    public void preConstructTestInstance(TestInstanceFactoryContext testInstanceFactoryContext, ExtensionContext extensionContext) throws Exception {
        System.out.println("preConstructTestInstance");
    }

}
