package com.algorithm.codility.easy;
public class PermMissingElem {

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
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * <p>
 * the function should return 4, as it is the missing element.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 */
