package org.example.algorithm.disjointset;

public class Main {
    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(5);

        System.out.println(disjointSet);
        disjointSet.union(0, 1);
        System.out.println(disjointSet);
        disjointSet.union(2, 3);
        System.out.println(disjointSet);
        disjointSet.union(0, 4);
        System.out.println(disjointSet);

        System.out.println(disjointSet.find(1)); // 1
        System.out.println(disjointSet.find(3)); // 3
        System.out.println(disjointSet.find(4)); // 1
    }
}
