package org.example.algorithm.disjointset;

import java.util.Arrays;

public class UnionFindSet {
    private int[] parent;

    public UnionFindSet(int size) {
        //初始化并查集，每个元素父节点是它自己，没有同类
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
        //寻找两个元素的父节点，若不相同，则设置为相同父节点
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    @Override
    public String toString() {
        return "UnionFindSet{" +
                "parent=" + Arrays.toString(parent) +
                '}';
    }
}
