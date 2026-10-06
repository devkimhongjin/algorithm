// JUNGOL #1024 · 내리막 길
// https://jungol.co.kr/problem/1024
// Language: Java
// Execution Time: 215 ms
// Memory: 37.8 MB

import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;
    static int[][] dp;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int dfs(int y, int x) {

        if (y == M - 1 && x == N - 1)
            return 1;

        if (dp[y][x] != -1)
            return dp[y][x];

        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {

            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= M || nx < 0 || nx >= N)
                continue;

            if (map[y][x] > map[ny][nx]) {
                dp[y][x] += dfs(ny, nx);
            }
        }

        return dp[y][x];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }
}