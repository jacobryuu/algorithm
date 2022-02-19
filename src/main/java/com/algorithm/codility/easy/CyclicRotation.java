package com.algorithm.codility.easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CyclicRotation {

    public int[] solution1(int[] A, int K) {

        int aLength = A.length;
        int[] B = new int[aLength];
        int x = 0;

        for (int i = 0; i < aLength; i++) {
            x = K + i;
            if (x >= aLength)
                x -= (Math.round(x / aLength) * aLength);
            B[x] = A[i];
        }

        return B;
    }

    public static int[] solution(int[] arrays, int k) {

        if (arrays.length <= 1) {
            return arrays;
        }
        Integer[] integerArray = Arrays.stream(arrays)
                .boxed()
                .toArray(Integer[]::new);
        List<Integer> listInt = Arrays.asList(integerArray);

        List<Integer> listRotation = null;

        for (int i = 0; i < k; i++) {
            listRotation = new ArrayList<>();
            listRotation.add(listInt.get(listInt.size() - 1));
            listRotation.addAll(listInt.subList(0, listInt.size() - 1));
            listInt = new ArrayList<>();
            listInt.addAll(listRotation);
        }
        int[] numArray = listRotation.stream().mapToInt(i -> i).toArray();

        return numArray;
    }
}

/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * <p>
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * <p>
 * For another example, given
 * A = [0, 0, 0]
 * K = 1
 * <p>
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * A = [1, 2, 3, 4]
 * K = 4
 * <p>
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * <p>
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */