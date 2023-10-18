package org.example.unittest;

import org.example.unittest.extension.BarExtension;
import org.example.unittest.extension.FooExtension;
import org.example.unittest.extension.TimingExtension;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;

//@ExtendWith(TimingExtension.class)
//@ExtendWith({MockitoExtension.class})
public class ExtensionDemo {

    @RegisterExtension
    static TimingExtension extension = new TimingExtension();

    @Test
    void test1() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test 1");

    }

    @Test
    void test2() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test 2");
    }

    @Nested
    @ExtendWith(TimingExtension.class)
    class RegisterExtensionDemo {
        @ExtendWith({MockitoExtension.class})
        @Test
        void mockTest() {
            // ...
        }

        @Test
        @ExtendWith({FooExtension.class, BarExtension.class})
        void extensionTest() {

        }
    }
}
