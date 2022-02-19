package com.algorithm.leetcode;
import java.util.ArrayList;
import java.util.Scanner;
public class Sort {

    public static void main(String[] args) {

    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }
}
