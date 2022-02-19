package com.algorithm.codility.ldf;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Exam01 {

    public int solution(String str) {

        int result = 0;
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (str.indexOf(ch) == str.lastIndexOf(ch)) {
                result += 1;
            }
        }
        return result;
    }

    public int solution2(String str) {

        Map<Character, Integer> hashMap = new ConcurrentHashMap<>(26);

        char[] arr = str.toCharArray();

        for (char ch : arr) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }
        int result = (int) hashMap.values()
                .stream()
                .filter(i -> i == 1)
                .count();

        return result;
    }
}
