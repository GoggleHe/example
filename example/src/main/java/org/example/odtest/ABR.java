package org.example.odtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ABR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        Matcher m = Pattern.compile("A=\\{(.+)},B=\\{(.+)},R=(.+)").matcher(s);

        if (m.matches()) {
            int[] A = Arrays.stream(m.group(1).split(",")).mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(m.group(2).split(",")).mapToInt(Integer::parseInt).toArray();
            Integer R = Integer.parseInt(m.group(3));
            System.out.println(getResult(A, B, R));
        }

        Matcher matcher = Pattern.compile("((\\d+[+*-])*\\d+)").matcher(s);
        String group = matcher.group(0);
        boolean b = matcher.find();
    }

    public static String getResult(int[] A, int[] B, Integer R) {
        StringBuilder sb = new StringBuilder();

        for (int a : A) {
            int cnt = 0;

            for (int b : B) {
                if (b < a) continue;
                if (b - a <= R || cnt == 0) {
                    sb.append("(").append(a).append(",").append(b).append(")");
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
