package com.algorithm.leetcode;
import java.util.ArrayList;
import java.util.HashSet;

public class FindAllNumbersDisappeared {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        HashSet<Integer> numsSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }

        HashSet<Integer> allNums = new HashSet<Integer>();
        for (int i = 1; i < nums.length + 1; i++) {
            allNums.add(i);
        }
        allNums.removeAll(numsSet);
        new ArrayList<>(allNums);

    }
}
