// JUNGOL #2000 · 동전교환
// https://jungol.co.kr/problem/2000
// Language: Java
// Execution Time: 303 ms
// Memory: 34.2 MB

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] coins;
    static int[] dp;

    static void func(int W) {
        Arrays.fill(dp, W + 1);
        dp[0] = 0;

        for (int i = 1; i <= W; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        N = Integer.parseInt(br.readLine());

        coins = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);

        int W = Integer.parseInt(br.readLine());

        dp = new int[W + 1];

        func(W);

        System.out.print(dp[W] > W ? "impossible" : dp[W]);
    }
}