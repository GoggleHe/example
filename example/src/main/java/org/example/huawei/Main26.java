package org.example.huawei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 求字符串中所有整数的最小和
 */
public class Main26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static String getResult(String s) {
        boolean isNegative = false;
        StringBuilder negative = new StringBuilder();

        //    int ans = 0;
        BigInteger ans = new BigInteger("0");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                if (isNegative) {
                    negative.append(c);
                } else {
                    //          ans += Integer.parseInt(c + "");
                    ans = ans.add(new BigInteger(c + ""));
                }
            } else {
                if (isNegative && negative.length() > 0) {
                    //          ans -= Integer.parseInt(negative.toString());
                    ans = ans.subtract(new BigInteger(negative.toString()));
                    negative = new StringBuilder();
                }

                isNegative = c == '-';
            }
        }

        if (negative.length() > 0) {
            //      ans -= Integer.parseInt(negative.toString());
            ans = ans.subtract(new BigInteger(negative.toString()));
        }

        return ans.toString();
    }
}
