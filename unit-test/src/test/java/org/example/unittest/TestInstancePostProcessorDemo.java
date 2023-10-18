package org.example.unittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

class TestInstancePostProcessorDemo {

    @Test
    @ExtendWith(MyTestInstancePostProcessor.class)
    void testTestInstancePostProcessor() {
        System.out.println("test");
    }

    static class MyTestInstancePostProcessor implements TestInstancePostProcessor {

        @Override
        public void postProcessTestInstance(Object o, ExtensionContext extensionContext) throws Exception {
            System.out.println("postProcessTestInstance");
        }
    }

}
