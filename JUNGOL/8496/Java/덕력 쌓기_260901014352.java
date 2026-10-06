// JUNGOL #8496 · 덕력 쌓기
// https://jungol.co.kr/problem/8496
// Language: Java
// Execution Time: 238 ms
// Memory: 49 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] m = new long[N];

        for (int i = 0; i < N; i++) {
            m[i] = Long.parseLong(br.readLine());
        }

        int left = 0;
        long sum = 0;
        int minDays = N + 1;

        for (int right = 0; right < N; right++) {

            sum += m[right];

            // 현재 구간 합이 M 이상이면
            // 왼쪽을 최대한 줄여본다.
            while (sum >= M) {

                minDays = Math.min(
                    minDays,
                    right - left + 1
                );

                sum -= m[left++];
            }
        }

        if (minDays == N + 1) {
            System.out.println("VIVIZ SAD");
        } else {
            System.out.println(minDays);
        }
    }
}