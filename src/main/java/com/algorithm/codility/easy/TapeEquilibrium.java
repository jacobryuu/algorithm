package com.algorithm.codility.easy;
import java.util.Arrays;

public class TapeEquilibrium {

    public int solution1(int[] arrays) {

        if (arrays.length >= 100000 || arrays.length == 0)
            return 0;
        int[] result = new int[arrays.length - 1];
        for (int i = 0; i < arrays.length - 1; i++) {
            int[] first = Arrays.copyOfRange(arrays, 0, i + 1);
            int[] second = Arrays.copyOfRange(arrays, i + 1, arrays.length);
            result[i] = Math.abs(
                    Arrays.stream(first).sum() - Arrays.stream(second).sum());
        }
        Arrays.sort(result);
        return result[0];
    }

    public int solution(int[] arrays) {
        long rightSum = 0;
        long leftSum = 0;
        long mini;

        leftSum = arrays[0];

        for (int i = 1; i < arrays.length; i++)
            rightSum += arrays[i];

        mini = Math.abs(rightSum - leftSum);

        for (int P = 1; P < arrays.length; P++) {
            if (Math.abs(rightSum - leftSum) < mini)
                mini = Math.abs(rightSum - leftSum);
            leftSum += arrays[P];
            rightSum -= arrays[P];
        }
        return (int) mini;
    }
}

/**
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * <p>
 * For example, consider array A such that:
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * <p>
 * We can split this tape in four places:
 * <p>
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * <p>
 * For example, given:
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * <p>
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */