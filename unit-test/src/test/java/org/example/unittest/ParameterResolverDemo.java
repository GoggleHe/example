package org.example.unittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;

class ParameterResolverDemo {

    @Test
    @ExtendWith(IntRandomParameterResolver.class)
    void injectsInteger(Integer i, Integer j) {
        System.out.println(i + "->" + j);
    }

    static class IntRandomParameterResolver implements ParameterResolver {
        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return parameterContext.getParameter().getType().isAssignableFrom(Integer.class);
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            boolean assignableFrom = parameterContext.getParameter().getType().isAssignableFrom(Integer.class);
            if (assignableFrom) {
                return (int) (Math.random() * 100);
            }
            return null;
        }
    }

}
