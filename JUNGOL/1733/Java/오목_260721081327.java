// JUNGOL #1733 · 오목
// https://jungol.co.kr/problem/1733
// Language: Java
// Execution Time: 180 ms
// Memory: 36.3 MB

import java.io.*;
import java.util.*;

public class Main {

    static final int BOARD_SIZE = 19;

    static int[][] board = new int[BOARD_SIZE + 1][BOARD_SIZE + 1];

    static int[] dr = {0, 1, 1, -1};
    static int[] dc = {1, 0, 1, 1};

    static boolean isInside(int r, int c) {
        return r >= 1 && r <= BOARD_SIZE
                && c >= 1 && c <= BOARD_SIZE;
    }

    static boolean isFive(int r, int c, int color, int dir) {
        int prevR = r - dr[dir];
        int prevC = c - dc[dir];

        if (isInside(prevR, prevC)
                && board[prevR][prevC] == color) {
            return false;
        }

        for (int i = 0; i < 5; i++) {
            int nr = r + dr[dir] * i;
            int nc = c + dc[dir] * i;

            if (!isInside(nr, nc)
                    || board[nr][nc] != color) {
                return false;
            }
        }

        int nextR = r + dr[dir] * 5;
        int nextC = c + dc[dir] * 5;

        if (isInside(nextR, nextC)
                && board[nextR][nextC] == color) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        for (int r = 1; r <= BOARD_SIZE; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= BOARD_SIZE; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int c = 1; c <= BOARD_SIZE; c++) {
            for (int r = 1; r <= BOARD_SIZE; r++) {
                if (board[r][c] == 0) {
                    continue;
                }

                int color = board[r][c];

                for (int dir = 0; dir < 4; dir++) {
                    if (isFive(r, c, color, dir)) {
                        System.out.println(color);
                        System.out.println(r + " " + c);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}