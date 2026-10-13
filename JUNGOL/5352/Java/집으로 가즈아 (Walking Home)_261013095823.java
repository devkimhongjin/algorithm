// JUNGOL #5352 · 집으로 가즈아 (Walking Home)
// https://jungol.co.kr/problem/5352
// Solved At: 2026-10-13 09:58:23 KST
// Language: Java
// Execution Time: 348 ms
// Memory: 56680 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dr = {1, 0};
        int[] dc = {0, 1};

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][N];

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            long[][][][] dp = new long[N][N][2][K + 1];

            if (map[0][0] != 'H') {
                if (map[1][0] != 'H')
                    dp[1][0][0][0] = 1;

                if (map[0][1] != 'H')
                    dp[0][1][1][0] = 1;
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    if (map[r][c] == 'H')
                        continue;

                    for (int dir = 0; dir < 2; dir++) {
                        for (int k = 0; k <= K; k++) {

                            long count = dp[r][c][dir][k];

                            if (count == 0)
                                continue;

                            for (int i = 0; i < 2; i++) {
                                int nr = r + dr[i];
                                int nc = c + dc[i];

                                if (nr >= N || nc >= N || map[nr][nc] == 'H')
                                    continue;

                                int nk = k + (dir == i ? 0 : 1);

                                if (nk > K)
                                    continue;

                                dp[nr][nc][i][nk] += count;
                            }
                        }
                    }
                }
            }

            long answer = 0;

            for (int k = 0; k <= K; k++) {
                answer += dp[N - 1][N - 1][0][k];
                answer += dp[N - 1][N - 1][1][k];
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}