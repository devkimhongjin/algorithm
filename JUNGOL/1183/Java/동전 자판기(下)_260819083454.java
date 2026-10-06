// JUNGOL #1183 · 동전 자판기(下)
// https://jungol.co.kr/problem/1183
// Language: Java
// Execution Time: 277 ms
// Memory: 36.9 MB

import java.io.*;
import java.util.*;

public class Main {
    static final int COIN = 6;
    static final int[] COST = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int W = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] coins = new int[COIN];

        for (int i = 0; i < COIN; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[W + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		int[][] used = new int[W + 1][COIN];

		for (int i = 0; i < COIN; i++) {
			for (int count = 0; count < coins[i]; count++) {
				for (int money = W; money >= COST[i]; money--) {

					if (dp[money - COST[i]] == -1) {
						continue;
					}

					if (dp[money] < dp[money - COST[i]] + 1) {
						dp[money] = dp[money - COST[i]] + 1;

						System.arraycopy(
							used[money - COST[i]], 0,
							used[money], 0,
							COIN
						);

						used[money][i]++;
					}
				}
			}
		}

        if (dp[W] == -1) {
            System.out.println(-1);
            return;
        }

        sb.append(dp[W]).append("\n");

        for (int i = 0; i < COIN; i++) {
            sb.append(used[W][i]).append(" ");
        }

        System.out.print(sb);
    }
}