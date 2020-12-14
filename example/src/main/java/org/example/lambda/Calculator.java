package org.example.lambda;

/**
 *
 **/
public class Calculator implements Computable{

    private Computable computable;

    public Calculator(Computable computable) {
        this.computable = computable;
    }

    @Override
    public int compute(int a, int b, int c) {
        return computable.compute(a, b, c);
    }
}
