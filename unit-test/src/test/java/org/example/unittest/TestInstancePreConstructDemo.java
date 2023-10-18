package org.example.unittest;

import org.example.unittest.extension.MyTestInstancePreConstructCallback;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class TestInstancePreConstructDemo {

    @Test
    @ExtendWith(MyTestInstancePreConstructCallback.class)
    void test() {
        System.out.println("test");
    }

}
