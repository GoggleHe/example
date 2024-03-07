package org.example.odtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 5键键盘问题
 */
public class FiveKeyBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commands = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int size = getResult(commands);

    }

    private static int getResult(int[] commands) {
        List<String> screen = new ArrayList<>();
        List<String> clip = new ArrayList<>();
        boolean isSelected = false;

        for (int command : commands) {
            switch (command) {
                case 1:
                    if (isSelected) {
                        screen.clear();
                        isSelected = false;
                    }
                    screen.add("a");
                    break;
                case 2:
                    if (isSelected) {
                        clip.clear();
                        clip.addAll(screen);
                    }
                    break;
                case 3:
                    if (isSelected) {
                        clip.clear();
                        clip.addAll(screen);
                        screen.clear();
                        isSelected = false;
                    }
                    break;
                case 4:
                    screen.clear();
                    screen.addAll(clip);
                    isSelected = false;
                    break;
                case 5:
                    if (screen.size() > 0) {
                        isSelected = true;
                    }
                    break;
                default:
                    break;
            }
        }


        return screen.size();
    }
}
