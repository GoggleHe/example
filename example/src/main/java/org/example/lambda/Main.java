package org.example.lambda;

import java.util.regex.Pattern;

/**
 * lambda表达式本质为接口的匿名实现类的对象
 **/
public class Main {

    public static void main(String[] args) {
        Computable computable = (a, b, c) -> {
            return a + b * c;
        };

        Calculator calculator = new Calculator((a, b, c) -> a - b - c);
        int compute = calculator.compute(1, 2, 3);
        System.out.println(compute);

        System.out.println(Integer.valueOf(4));

        if (true) {
            System.out.println("if");
        } else if (true) {
            System.out.println("else if");
        }

        boolean driver_info = Pattern.matches("order_info_\\d{6}", "driver_info");
        System.out.println(driver_info);


    }

}
