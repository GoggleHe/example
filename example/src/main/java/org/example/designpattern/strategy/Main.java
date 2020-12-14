package org.example.designpattern.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Cat[] arr = {new Cat(3), new Cat(1), new Cat(2)};

        Arrays.sort(arr, new CatComparator());

        System.out.println(Arrays.toString(arr));

    }
}
