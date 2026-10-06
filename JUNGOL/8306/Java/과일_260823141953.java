// JUNGOL #8306 · 과일
// https://jungol.co.kr/problem/8306
// Language: Java
// Execution Time: 382 ms
// Memory: 46.8 MB

import java.io.*;
import java.util.*;

public class Main {

    static long minMove(long left, long right) {
        if (left >= 0) {
            return right;
        }

        if (right <= 0) {
            return -left;
        }

        long L = -left;
        long R = right;

        return Math.min(2 * L + R, L + 2 * R);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] fruits = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            fruits[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(fruits);

        int answer = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {

            while (left <= right &&
                    minMove(fruits[left], fruits[right]) > K) {
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }
}