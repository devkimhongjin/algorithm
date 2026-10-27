// JUNGOL #1871 · 줄세우기
// https://jungol.co.kr/problem/1871
// Solved At: 2026-10-12 17:50:17 KST
// Language: Java
// Execution Time: 142 ms
// Memory: 32.9 MB

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(N - maxLength);
    }
}