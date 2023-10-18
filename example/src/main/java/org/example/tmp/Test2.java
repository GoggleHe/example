package org.example.tmp;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public String reverse(String str) {

        List<String> list = new ArrayList<>();
        int splitPointer = 0;
        for (int i = 1; i < str.length(); i++) {
            if (isWord(str.charAt(i)) && isPoint(str.charAt(i - 1)) || isWord(str.charAt(i - 1)) && isPoint(str.charAt(i))) {
                list.add(str.substring(splitPointer, i));
                splitPointer = i;
            }
        }
        list.add(str.substring(splitPointer, str.length()));
        String result = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            String temp = list.get(i);
            result += temp;
        }
        return result;
        
    }

    public boolean isWord(char word) {
        return word >= 'a' && word <= 'z';
    }

    public boolean isPoint(char word) {
        return word == '.';
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        String str = "abc...a.b.cccasdf...";
        String reverse = test.reverse(str);
        System.out.println(reverse);
    }
}
