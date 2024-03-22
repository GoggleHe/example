package org.example.algorithm.disjointset;

public class Main {
    public static void main(String[] args) {
        UnionFindSet unionFindSet = new UnionFindSet(5);

        System.out.println(unionFindSet);
        unionFindSet.union(0, 1);
        System.out.println(unionFindSet);
        unionFindSet.union(2, 3);
        System.out.println(unionFindSet);
        unionFindSet.union(0, 4);
        System.out.println(unionFindSet);

        System.out.println(unionFindSet.find(1)); // 1
        System.out.println(unionFindSet.find(3)); // 3
        System.out.println(unionFindSet.find(4)); // 1
        System.out.println(unionFindSet.find(0)); // 1
        System.out.println(unionFindSet);
    }
}
