// JUNGOL #3803 · Wifi Setup
// https://jungol.co.kr/problem/3803
// Language: Java
// Execution Time: 185 ms
// Memory: 34.6 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] cows = new int[N];

        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cows);

        /*
         * dp[i] = 앞에서부터 i마리의 소를 모두 덮는 최소 비용
         *
         * dp[0] = 소를 한 마리도 덮지 않은 비용
         * dp[N] = 모든 소를 덮은 최소 비용
         */
        double[] dp = new double[N+1];
        Arrays.fill(dp, Double.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            /*
             * 마지막 기지국이
             * cows[j]부터 cows[i - 1]까지 덮는 경우
             */
            for (int j = 0; j < i; j++) {
                double radius = (cows[i - 1] - cows[j]) / 2.0;
                double stationCost = A + B * radius;

                dp[i] = Math.min(
                        dp[i],
                        dp[j] + stationCost
                );
            }
        }

        double answer = dp[N];

        // 정수이면 소수점 없이 출력
        if (answer == (long) answer) {
            System.out.println((long) answer);
        } else {
            System.out.println(answer);
        }
    }
}