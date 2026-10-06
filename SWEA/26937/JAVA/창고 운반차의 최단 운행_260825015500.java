// SWEA #26937 · 창고 운반차의 최단 운행
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpF0KHbHHBIQj
// Language: JAVA
// Execution Time: 104 ms
// Memory: 30576 KB

import java.io.*;
import java.util.*;

class Solution {

    // 위치와 시작점으로부터의 이동 횟수를 저장
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

    // 좌, 우, 상, 하
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int N;
    static int[][] board;
    static boolean[][] visited;

    static Loc start;
    static Loc end;

    // BFS로 시작점에서 도착점까지의 최단 거리 탐색
    static int bfs() {

        Queue<Loc> queue = new ArrayDeque<>();

        // 시작점 방문 처리 후 큐에 삽입
        visited[start.row][start.col] = true;
        queue.offer(new Loc(start.row, start.col, 0));

        while (!queue.isEmpty()) {

            Loc cur = queue.poll();

            // 도착점에 처음 도달한 경우가 최단 거리
            if (cur.row == end.row && cur.col == end.col) {
                return cur.move;
            }

            // 현재 위치에서 상하좌우 탐색
            for (int i = 0; i < 4; i++) {

                int nr = cur.row + dr[i];
                int nc = cur.col + dc[i];

                // 범위를 벗어나거나 이미 방문했거나 벽이면 이동 불가
                if (nr < 0 || nr >= N || nc < 0 || nc >= N
                        || visited[nr][nc]
                        || board[nr][nc] == 1) {
                    continue;
                }

                // 같은 위치가 큐에 중복으로 들어가지 않도록
                // 큐에 넣는 순간 방문 처리
                visited[nr][nc] = true;

                queue.offer(new Loc(nr, nc, cur.move + 1));
            }
        }

        // 도착점까지 갈 수 없는 경우
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

            // 지도 입력 및 시작점, 도착점 위치 저장
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

            // 시작점부터 도착점까지 최단 거리 탐색
            int result = bfs();

            if (result == -1) {
                // 도착할 수 없는 경우
                sb.append(0);
            } else {
                // 시작점과 도착점을 제외한 지나간 칸의 수
                sb.append(result - 1);
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}