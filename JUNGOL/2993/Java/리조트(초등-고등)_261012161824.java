// JUNGOL #2993 · 리조트(초등/고등)
// https://jungol.co.kr/problem/2993
// Solved At: 2026-10-12 16:18:24 KST
// Language: Java
// Execution Time: 261 ms
// Memory: 33920 MB

import java.io.*;
import java.util.*;

public class Main {

    static final int[] cost = {10000, 25000, 37000};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] free = new boolean[N + 1];

        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                free[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int[][] dp = new int[N + 6][N + 6];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[1][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int coupon = 0; coupon <= N; coupon++) {

                if (dp[i][coupon] == Integer.MAX_VALUE) continue;

                if (free[i]) {
                    dp[i + 1][coupon] = Math.min(
                        dp[i + 1][coupon],
                        dp[i][coupon]
                    );
                    continue;
                }

                // 쿠폰 3개 사용
                if (coupon >= 3) {
                    dp[i + 1][coupon - 3] = Math.min(
                        dp[i + 1][coupon - 3],
                        dp[i][coupon]
                    );
                }

                // 1일권
                dp[i + 1][coupon] = Math.min(
                    dp[i + 1][coupon],
                    dp[i][coupon] + cost[0]
                );

                // 3일권 + 쿠폰 1개
                dp[Math.min(N + 1, i + 3)][coupon + 1] = Math.min(
                    dp[Math.min(N + 1, i + 3)][coupon + 1],
                    dp[i][coupon] + cost[1]
                );

                // 5일권 + 쿠폰 2개
                dp[Math.min(N + 1, i + 5)][coupon + 2] = Math.min(
                    dp[Math.min(N + 1, i + 5)][coupon + 2],
                    dp[i][coupon] + cost[2]
                );
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int coupon = 0; coupon <= N; coupon++) {
            answer = Math.min(answer, dp[N + 1][coupon]);
        }

        System.out.println(answer);
    }
}