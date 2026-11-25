// BAEKJOON #12100 · 2048 (Easy)
// https://acmicpc.net/problem/12100
// Solved At: 2026-11-25 16:38:02 KST
// Language: Java
// Execution Time: 148 ms
// Memory: 21636 KB

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int maxBlock;

    static void dfs(int[][] grid, int depth) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxBlock = Math.max(maxBlock, grid[i][j]);
                }
            }
            return;
        }

        int[][] current = copyGrid(grid);
        for (int dir = 0; dir < 4; dir++) {
            int[][] moved = moveLeft(current);
            dfs(moved, depth + 1);
            current = rotate90(current);
        }
    }

    static int[][] moveLeft(int[][] board) {
        int[][] next = new int[N][N];

        for (int i = 0; i < N; i++) {
            int idx = 0; 
            int prev = 0;

            for (int j = 0; j < N; j++) {
                int val = board[i][j];
                if (val == 0) continue;

                if (prev == 0) {
                    prev = val;
                } else if (prev == val) {
                    next[i][idx++] = prev * 2;
                    prev = 0;
                } else {
                    next[i][idx++] = prev;
                    prev = val;
                }
            }
            if (prev != 0) {
                next[i][idx] = prev;
            }
        }
        return next;
    }

    static int[][] rotate90(int[][] board) {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N - 1 - i] = board[i][j];
            }
        }
        return rotated;
    }

    static int[][] copyGrid(int[][] board) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { // i < N 오타 수정
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxBlock = 0;
        dfs(grid, 0);
        System.out.println(maxBlock);
    }
}
