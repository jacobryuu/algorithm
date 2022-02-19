package com.algorithm.codility.ldf;

public class Exam02 {

    public String solution(String S) {

        String str = S;
        int offset = S.length();
        if (str.contains(".")) {
            offset = str.indexOf(".");
            str = str.substring(0, str.indexOf("."));
        }

        int step = 3;
        int length = 0;
        if (str.contains("-")) {
            length = str.length() - 1;
        } else {
            length = str.length();
        }
        int num = length / step;
        StringBuilder stringBuilder = new StringBuilder(S);

        for (int i = 0; i < num; i++) {
            offset = offset - 3;
            stringBuilder.insert(offset, ",");
        }
        return stringBuilder.toString();
    }
}
