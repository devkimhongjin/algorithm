// SWEA #7733 · 치즈 도둑
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWrDOdQqRCUDFARG
// Solved At: 2026-09-16 15:14:00 KST
// Language: JAVA
// Execution Time: 337 ms
// Memory: 39804 KB

import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[][] cheese;
    static boolean[][] visited;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    // day일까지 먹힌 상태에서
    // 현재 위치와 연결된 살아있는 치즈를 모두 방문 처리
    static void dfs(int r, int c, int day) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
            }

            // 이미 방문했거나
            // 현재 날짜 이하의 맛이면 이미 먹힌 치즈
            if (visited[nr][nc] || cheese[nr][nc] <= day) {
                continue;
            }

            dfs(nr, nc, day);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            cheese = new int[N][N];

            int maxTaste = 0;

            // 치즈 정보 입력
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {
                    cheese[r][c] = Integer.parseInt(st.nextToken());
                    maxTaste = Math.max(maxTaste, cheese[r][c]);
                }
            }

            int maxCount = 1;

            // day일까지 치즈를 먹었다고 가정
            for (int day = 1; day < maxTaste; day++) {

                visited = new boolean[N][N];

                int count = 0;

                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {

                        // 이미 방문했거나 먹힌 치즈
                        if (visited[r][c] || cheese[r][c] <= day) {
                            continue;
                        }

                        // 새로운 치즈 덩어리 발견
                        count++;

                        dfs(r, c, day);
                    }
                }

                maxCount = Math.max(maxCount, count);
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(maxCount)
              .append("\n");
        }

        System.out.print(sb);
    }
}