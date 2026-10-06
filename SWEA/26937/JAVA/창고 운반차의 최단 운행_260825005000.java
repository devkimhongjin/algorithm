// SWEA #26937 · 창고 운반차의 최단 운행
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpF0KHbHHBIQj
// Language: JAVA
// Execution Time: 104 ms
// Memory: 30848 KB

import java.io.*;
import java.util.*;

class Solution {

    static class Loc {
        int row;
        int col;
        int move;

        public Loc(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int N;
    static int[][] board;
    static boolean[][] visited;

    static Loc start;
    static Loc end;

    static int bfs() {

        Deque<Loc> queue = new ArrayDeque<>();

        visited[start.row][start.col] = true;
        queue.offer(new Loc(start.row, start.col, 0));

        while (!queue.isEmpty()) {

            Loc cur = queue.poll();

            if (cur.row == end.row && cur.col == end.col) {
                return cur.move;
            }

            for (int i = 0; i < 4; i++) {

                int nr = cur.row + dr[i];
                int nc = cur.col + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N
                        || visited[nr][nc]
                        || board[nr][nc] == 1) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new Loc(nr, nc, cur.move + 1));
            }
        }

        return -1;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#")
              .append(tc)
              .append(" ");

            N = Integer.parseInt(br.readLine());

            board = new int[N][N];
            visited = new boolean[N][N];

            for (int r = 0; r < N; r++) {

                String line = br.readLine();

                for (int c = 0; c < N; c++) {

                    int input = line.charAt(c) - '0';

                    board[r][c] = input;

                    if (input == 2) {
                        start = new Loc(r, c, 0);
                    } else if (input == 3) {
                        end = new Loc(r, c, 0);
                    }
                }
            }

            int result = bfs();

            if (result == -1) {
                sb.append(0);
            } else {
                sb.append(result - 1);
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}