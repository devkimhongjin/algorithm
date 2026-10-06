// JUNGOL #8075 · 안녕
// https://jungol.co.kr/problem/8075
// Language: Java
// Execution Time: 159 ms
// Memory: 33.2 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        int[] health = new int[N];
        int[] pleasure = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pleasure[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100];

        for (int i = 0; i < N; i++) {
            for (int h = 99; h >= health[i]; h--) {
                dp[h] = Math.max(
                        dp[h],
                        dp[h - health[i]] + pleasure[i]
                );
            }
        }

        int answer = 0;

        for (int h = 0; h < 100; h++) {
            answer = Math.max(answer, dp[h]);
        }

        System.out.println(answer);
    }
}