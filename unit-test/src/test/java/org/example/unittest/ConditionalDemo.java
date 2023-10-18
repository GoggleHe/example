package org.example.unittest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class ConditionalDemo {

    /**
     * Jre版本
     */
    @Nested
    class JreVersion {
        @Test
        @EnabledOnJre({JRE.JAVA_8})
        void testJre8() {
            System.out.println("JAVA_8");
        }

        @Test
        @EnabledOnJre({JRE.JAVA_11})
        void testJre11() {
            System.out.println("JAVA_11");
        }

        @Test
        @DisabledOnJre({JRE.JAVA_8})
        void testDisableJre8() {
            System.out.println("Disable JAVA_8");
        }

        @Test
        @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
        public void enabledForJava8To17() {
            System.out.println("Method[enabledForJava8To17] executed.");
        }

        @Test
        @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
        public void disabledForJava11To17() {
            System.out.println("Method[disabledForJava11To17] executed.");
        }
    }

    /**
     * 操作系统
     */
    @Nested
    class Os {
        @Test
        @EnabledOnOs(OS.WINDOWS)
        public void enabledOnWindows() {
            System.out.println("Windows操作系统下执行");
        }

        @Test
        @DisabledOnOs(OS.LINUX)
        public void disabledOnLinux() {
            System.out.println("Linux操作系统下不执行");
        }
    }

    /**
     * 系统属性
     */
    @Nested
    class SystemProperty {
        @Test
        @EnabledIfSystemProperty(named = "user.language", matches = "zh")
        public void enabledIfSystemPropertyUserLanguageIsZh() {
            System.out.println("当前操作系统用户语言是中文");
        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
        public void disabledIfSystemProperty() {
            System.out.println("64位操作系统不执行");
        }
    }

    /**
     * 环境变量
     */
    @Nested
    class Env{
        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*")
        public void enabledIfEnvironmentVariable() {
            System.out.println("环境变量JAVA_HOME存在时执行");
        }

        @Test
        @DisabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*17.*")
        public void disabledIfEnvironmentVariable() {
            System.out.println("环境变量JAVA_HOME存在字符17时不执行");
        }
    }

    /**
     * 自定义
     */
    @Nested
    class Custom{
        @Test
        @EnabledIf("customCondition")
        public void enabledIf() {
            System.out.println("Method[enabledIf] executed.");
        }

        @Test
        @DisabledIf("customCondition")
        public void disabledIf() {
            System.out.println("Method[disabledIf] executed.");
        }

        private boolean customCondition() {
            return true;
        }
    }
}
