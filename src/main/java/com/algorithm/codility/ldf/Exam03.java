package com.algorithm.codility.ldf;
import java.util.Arrays;
public class Exam03 {
    public int solution(int[] A) {
        if (A.length < 3)
            return -1;
        Arrays.sort(A);
        int length = A.length;
        if (A[length - 1] < 0)
            return A[length - 1] * A[length - 2] * A[length - 3];
        int p1 = A[length - 1] * A[length - 2] * A[length - 3];
        int p2 = A[length - 1] * A[0] * A[1];

        return p1 > p2 ? p1 : p2;

    }
}
