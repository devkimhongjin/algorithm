// JUNGOL #5607 · 피자먹고 기분 피자
// https://jungol.co.kr/problem/5607
// Language: Java
// Execution Time: 469 ms
// Memory: 36.9 MB

import java.io.*;
import java.util.*;

public class Main {

    static class Pizza {
        int cost;
        int taste;

        Pizza(int cost, int taste) {
            this.cost = cost;
            this.taste = taste;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        Pizza[] pizzas = new Pizza[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int cost = Integer.parseInt(st.nextToken());
            int taste = Integer.parseInt(st.nextToken());

            pizzas[i] = new Pizza(cost, taste);
        }

        int[] dp = new int[K + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (Pizza pizza : pizzas) {
            for (int taste = K; taste >= 0; taste--) {

                if (dp[taste] == Integer.MAX_VALUE) {
                    continue;
                }

                int nextTaste = Math.min(K, taste + pizza.taste);
                int nextCost = dp[taste] + pizza.cost;

                if (nextCost <= M) {
                    dp[nextTaste] = Math.min(
                        dp[nextTaste],
                        nextCost
                    );
                }
            }
        }

        if (dp[K] == Integer.MAX_VALUE) {
            System.out.print(":(");
        } else {
            System.out.print(dp[K]);
        }
    }
}