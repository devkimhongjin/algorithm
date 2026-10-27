// SWEA #1952 · [모의 SW 역량테스트] 수영장
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq
// Solved At: 2026-10-12 15:09:00 KST
// Language: JAVA
// Execution Time: 88 ms
// Memory: 25600 KB


import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            int[] cost = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            int[] days = new int[13];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[13];

            for (int i = 1; i <= 12; i++) {
                int oneMonthCost = Math.min(
                    days[i] * cost[0], cost[1]
                );

                dp[i] = dp[i - 1] + oneMonthCost;

                if (i >= 3) {
                    dp[i] = Math.min(
                        dp[i], dp[i - 3] + cost[2]
                    );
                } else {
                    dp[i] = Math.min(dp[i], cost[2]);
                }
            }

            int minCost = Math.min(dp[12], cost[3]);

            sb.append(minCost).append("\n");
        }

        System.out.print(sb);
    }
}
