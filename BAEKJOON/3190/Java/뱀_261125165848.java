// BAEKJOON #3190 · 뱀
// https://acmicpc.net/problem/3190
// Solved At: 2026-11-25 16:58:48 KST
// Language: Java
// Execution Time: 108 ms
// Memory: 14612 KB

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[] dr = {0, 1, 0, -1}; 
    static int[] dc = {1, 0, -1, 0};

    static class Loc {
        int r, c;
        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 2; // 사과
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> moves = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            moves.put(time, dir);
        }

        System.out.println(simulate(moves));
    }

    static int simulate(Map<Integer, Character> moves) {
        Deque<Loc> snake = new ArrayDeque<>();
        snake.add(new Loc(0, 0));
        board[0][0] = 1;

        int dir = 0;
        int time = 0;

        while (true) {
            time++;
            Loc head = snake.peekFirst();
            int nr = head.r + dr[dir];
            int nc = head.c + dc[dir];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 1) {
                return time;
            }

            if (board[nr][nc] != 2) {
                Loc tail = snake.pollLast();
                board[tail.r][tail.c] = 0;
            }

            board[nr][nc] = 1;
            snake.addFirst(new Loc(nr, nc));

            if (moves.containsKey(time)) {
                char turn = moves.get(time);
                if (turn == 'D') {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir + 3) % 4;
                }
            }
        }
    }
}
