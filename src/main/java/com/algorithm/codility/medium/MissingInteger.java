package com.algorithm.codility.medium;
public class MissingInteger {

    public int solution(int[] nums) {
        int length = nums.length;
        boolean[] visit = new boolean[length + 1];
        for (int num : nums) {
            if (num > 0 && num <= length)
                visit[num] = true;
        }
        for (int i = 1; i <= length; ++i)
            if (!visit[i])
                return i;
        return length + 1;
    }
}

/**
 * This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
