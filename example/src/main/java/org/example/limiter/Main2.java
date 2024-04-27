package org.example.limiter;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String l = sc.nextLine();

        System.out.println(getResult(s, l));
    }

    public static int getResult(String s, String l) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < l.length()) {
            if (s.charAt(i) == l.charAt(j)) {
                i++;
            }
            j++;
        }

        if (i == s.length()) return j - 1;
        else return -1;
    }
}
