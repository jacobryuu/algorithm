package com.algorithm.leetcode;

import java.util.Arrays;
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Arrays.stream(ProductExceptSelf1(nums)).forEach(System.out::print);

    }

    public static int[] ProductExceptSelf(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return null;
        }
        int[] answer = new int[nums.length];

        int tmp = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = tmp;
            tmp *= nums[i];
        }

        tmp = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= tmp;
            tmp *= nums[i];
        }
        return answer;
    }

    public static int[] ProductExceptSelf1(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return null;
        }

        int[] left = new int[nums.length];

        int tmp = 1;

        for (int i = 0; i < nums.length; i++) {
            left[i] = tmp;
            tmp *= nums[i];
        }

        tmp = 1;
        int[] right = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = tmp;
            tmp *= nums[i];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}
