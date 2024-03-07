package org.example.algorithm.disjointset;

import java.util.Arrays;

public class DisjointSet {
    private int[] parent;

    public DisjointSet(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // 路径压缩
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    @Override
    public String toString() {
        return "DisjointSet{" +
                "parent=" + Arrays.toString(parent) +
                '}';
    }
}
