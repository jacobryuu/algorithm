package com.algorithm.leetcode;
import java.util.Arrays;
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 0, 1,1,2};
        int p0 = 0;
        int curr = 0;
        int p2 = nums.length - 1;
        int tmp = 0;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0] = nums[curr];
                nums[curr] = tmp;
                curr += 1;
                p0 += 1;

            } else if (nums[curr] == 2) {
                tmp = nums[p2];
                nums[p2] = nums[curr];
                nums[curr] = tmp;
                p2 -= 1;
            } else {
                curr += 1;
            }
        }

        Arrays.stream(nums).forEach(System.out::print);

    }


}
