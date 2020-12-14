package org.example.lambda;

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

    }

}
