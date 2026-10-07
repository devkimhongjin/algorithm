// JUNGOL #5711 · 헨젤과 그레텔
// https://jungol.co.kr/problem/5711
// Solved At: 2026-10-07 15:47:35 KST
// Language: Java
// Execution Time: 349 ms
// Memory: 35432 MB

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N + 1][M + 1];

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            grid[r][c] = 1;
        }

        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            grid[r][c] = 2;
        }

        int[][][] dp = new int[N + 1][M + 1][A + 1];

        int startRock = grid[1][1] == 1 ? 1 : 0;
        dp[1][1][startRock] = 1;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {

                if (grid[r][c] == 2)
                    continue;

                if (r == 1 && c == 1)
                    continue;

                int add = grid[r][c] == 1 ? 1 : 0;

                for (int rock = add; rock <= A; rock++) {
                    int prevRock = rock - add;

                    if (r > 1)
                        dp[r][c][rock] += dp[r - 1][c][prevRock];

                    if (c > 1)
                        dp[r][c][rock] += dp[r][c - 1][prevRock];
                }
            }
        }

        System.out.print(dp[N][M][A]);
    }
}