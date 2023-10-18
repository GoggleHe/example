package org.example.unittest;

import org.example.unittest.extension.MyTestWatcher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MyTestWatcher.class)
public class TestWatcherDemo {

    @Test
    void succeedingTest() {
    }

    @Test
    void failingTest() {
//        fail("a failing test");
    }

    @Test
    void abortTest() {

    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

}
