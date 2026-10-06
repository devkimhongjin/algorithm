// JUNGOL #2000 · 동전교환
// https://jungol.co.kr/problem/2000
// Language: Java
// Execution Time: 543 ms
// Memory: 34.2 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        int[] coins = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);

        int W = Integer.parseInt(br.readLine());

        int[] dp = new int[W + 1];
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

        System.out.print(dp[W] > W ? "impossible" : dp[W]);
    }
}