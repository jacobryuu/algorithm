package com.algorithm.codility.medium;
import java.util.Arrays;
public class MaxCounters {

    public int[] solution1(int N, int[] A) {
        int[] res = new int[N];
        int maxValue = 0;
        for (int a : A) {
            if (a == N + 1) {
                Arrays.fill(res, maxValue);
            } else {
                res[a - 1]++;
                maxValue = Math.max(maxValue, res[a - 1]);
            }
        }
        return res;
    }

    public int[] solution(int N, int[] A) {
        int[] res = new int[N];
        int currentMaximumValue = 0;
        int minValue = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                if (minValue < currentMaximumValue) {
                    minValue = currentMaximumValue;
                }
            } else {
                if (res[A[i] - 1] < minValue) {
                    res[A[i] - 1] = minValue;
                }
                res[A[i] - 1] += 1;
                if (res[A[i] - 1] > currentMaximumValue)
                    currentMaximumValue = res[A[i] - 1];
            }
        }

        for (int j = 0; j < res.length; j++) {
            res[j] = res[j] < minValue ? minValue : res[j];
        }
        return res;
    }
}

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * <p>
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * <p>
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 * <p>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * <p>
 * For example, given integer N = 5 and array A such that:
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * <p>
 * the values of the counters after each consecutive operation will be:
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 * <p>
 * The goal is to calculate the value of every counter after all operations.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] A); }
 * <p>
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * <p>
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */