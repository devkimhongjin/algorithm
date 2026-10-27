// SWEA #5656 · [모의 SW 역량테스트] 벽돌 깨기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo
// Solved At: 2026-10-14 12:08:00 KST
// Language: JAVA
// Execution Time: 192 ms
// Memory: 64532 KB


import java.io.*;
import java.util.*;

public class Solution {

    static int N, W, H;
    static int minBrickLeft;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(List<Integer>[] grid, int depth, int brickLeft) {
        if (brickLeft == 0) {
            minBrickLeft = 0;
            return;
        }

        if (depth == N) {
            minBrickLeft = Math.min(minBrickLeft, brickLeft);
            return;
        }

        for (int c = 0; c < W; c++) {
            if (grid[c].isEmpty()) continue;

            List<Integer>[] nextGrid = new ArrayList[W];

            for (int i = 0; i < W; i++) {
                nextGrid[i] = new ArrayList<>(grid[i]);
            }

            int removed = breakBrick(nextGrid, c);

            dfs(nextGrid, depth + 1, brickLeft - removed);

            if (minBrickLeft == 0) return;
        }
    }

    static int breakBrick(List<Integer>[] grid, int col) {
        boolean[][] destroyed = new boolean[W][H];
        Queue<int[]> queue = new ArrayDeque<>();

        int start = grid[col].size() - 1;

        queue.offer(new int[]{col, start});
        destroyed[col][start] = true;

        int removed = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int c = cur[0];
            int r = cur[1];

            int power = grid[c].get(r);
            removed++;

            for (int d = 0; d < 4; d++) {
                for (int k = 1; k < power; k++) {
                    int nc = c + dc[d] * k;
                    int nr = r + dr[d] * k;

                    if (nc < 0 || nc >= W ||
                        nr < 0 || nr >= H) {
                        break;
                    }

                    if (nr >= grid[nc].size()) continue;
                    if (destroyed[nc][nr]) continue;

                    destroyed[nc][nr] = true;
                    queue.offer(new int[]{nc, nr});
                }
            }
        }

        for (int c = 0; c < W; c++) {
            for (int r = grid[c].size() - 1; r >= 0; r--) {
                if (destroyed[c][r]) {
                    grid[c].remove(r);
                }
            }
        }

        return removed;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            List<Integer>[] grid = new ArrayList[W];

            for (int i = 0; i < W; i++) {
                grid[i] = new ArrayList<>();
            }

            int brickLeft = 0;

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < W; j++) {
                    int input = Integer.parseInt(st.nextToken());

                    if (input != 0) {
                        grid[j].add(0, input);
                        brickLeft++;
                    }
                }
            }

            minBrickLeft = brickLeft;

            dfs(grid, 0, brickLeft);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(minBrickLeft)
              .append("\n");
        }

        System.out.print(sb);
    }
}
