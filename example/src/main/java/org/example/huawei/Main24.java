package org.example.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 求幸存数之和
 */
public class Main24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int jump = Integer.parseInt(sc.nextLine());
        int left = Integer.parseInt(sc.nextLine());

        System.out.println(new Main24().sumOfLeft(nums, jump, left));
    }

    public int sumOfLeft(int[] nums, int jump, int left) {
        ArrayList<Integer> list =
                (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());

        // 从起跳点开始的话，需要跳jump+1次，到达需要删除的节点
        // 从起跳点下一个节点开始的话，需要跳jump次，到达需要删除的节点
        // 这里我们从起跳点的下一个节点开始,初始时起跳点为索引0，因此下一个节点为索引1
        int start = 1;

        // 如果剩余节点数 > 幸存数量，则还需要继续删除节点
        while (list.size() > left) {
            // 跳 jump 次
            start += jump;
            // 为了避免越界，新起跳点索引位置对剩余节点数取余
            start %= list.size();
            list.remove(start);
        }

        return list.stream().reduce(Integer::sum).orElse(0);
    }
}
