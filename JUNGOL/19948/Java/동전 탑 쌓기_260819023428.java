// JUNGOL #19948 · 동전 탑 쌓기
// https://jungol.co.kr/problem/19948
// Language: Java
// Execution Time: 551 ms
// Memory: 39.5 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] dp = new long[N + 1][N + 1];

        for (int k = 0; k <= N; k++) {
            dp[0][k] = 1;
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= N; k++) {

                dp[n][k] = dp[n][k - 1];

                if (n >= k) {
                    dp[n][k] += dp[n - k][k];
                }
            }
        }

        System.out.print(dp[N][N]);
	}
}