package org.example.niuke;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 精准核酸检测
 */
public class Main2 {

    static class UnionFindSet {
        private int[] parent;

        public UnionFindSet(int length) {
            parent = new int[length];
            for (int i = 0; i < length; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[x] = rootY;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
    }

    public static void main(String[] args) {
        UnionFindSet unionFindSet = new UnionFindSet(5);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        pq.add(1);
        pq.poll();
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

}
