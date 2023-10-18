package org.example.unittest;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class TestTemplateDemo {

    @TestTemplate
    @ExtendWith(SimpleTestTemplateExtension.class)
    void test(Integer val1, Integer val2) {
        System.out.println("value 1: " + val1 + " || value 2: " + val2);
    }

    @TestTemplate
    @ExtendWith(SimpleTestTemplateExtension.class)
    void test(Integer val1, Integer val2, String val3) {
        System.out.println("value 1: " + val1 + " || value 2: " + val2 + " || value 3: " + val3);
    }

    static class SimpleTestTemplateExtension implements TestTemplateInvocationContextProvider {
        // 是否支持该模板方法，返回false将不会执行provideTestTemplateInvocationContexts
        // (ExtensionContext context)方法，你当然可以根据上下文做些额外判断
        @Override
        public boolean supportsTestTemplate(ExtensionContext context) {
            return true;
        }

        @Override
        public Stream<TestTemplateInvocationContext>
        provideTestTemplateInvocationContexts(ExtensionContext context) {
            return IntStream.rangeClosed(1, 50) // 将会产生50次参数，意味着模板方法会被执行50次
                    .mapToObj(n -> new TestTemplateInvocationContext() { // 实例化

                        @Override
                        public List<Extension> getAdditionalExtensions() {
                            return Collections.singletonList(new ParameterResolver() { // 实例化
                                @Override
                                public boolean supportsParameter(ParameterContext parameterContext,
                                                                 ExtensionContext extensionContext)
                                        throws ParameterResolutionException {
                                    Class<?> type = parameterContext.getParameter().getType();
                                    // 支持Integer和String类型的参数
                                    return type.isAssignableFrom(Integer.class)
                                            || type.isAssignableFrom(String.class);
                                }

                                @Override // 产生随机整数
                                public Object resolveParameter(ParameterContext parameterContext,
                                                               ExtensionContext extensionContext)
                                        throws ParameterResolutionException {
                                    Class<?> type = parameterContext.getParameter().getType();
                                    if (type.isAssignableFrom(String.class)) {
                                        return UUID.randomUUID().toString();
                                    } else if (type.isAssignableFrom(Integer.class)) {
                                        return (int) (Math.random() * 100);
                                    }
                                    return null;
                                }
                            });
                        }
                    });
        }
    }
}
