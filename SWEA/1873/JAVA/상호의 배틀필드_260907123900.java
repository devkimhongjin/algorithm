// SWEA #1873 · 상호의 배틀필드
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
// Language: JAVA
// Execution Time: 90 ms
// Memory: 27392 KB

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] board = new char[H][W];

            int tankRow = 0;
            int tankCol = 0;

            // 상 하 좌 우
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            char[] directions = {'^', 'v', '<', '>'};
            char[] commands = {'U', 'D', 'L', 'R'};

            int dir = -1;

            // 맵 입력
            for (int i = 0; i < H; i++) {
                String input = br.readLine();

                for (int j = 0; j < W; j++) {
                    board[i][j] = input.charAt(j);

                    // 전차 위치 및 방향 확인
                    if (board[i][j] == '^' || board[i][j] == 'v' ||
                        board[i][j] == '<' || board[i][j] == '>') {

                        tankRow = i;
                        tankCol = j;

                        for (int k = 0; k < 4; k++) {
                            if (board[i][j] == directions[k]) {
                                dir = k;
                                break;
                            }
                        }
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            char[] input = br.readLine().toCharArray();

            // 명령 처리
            for (char c : input) {

                // 포탄 발사
                if (c == 'S') {
                    int nr = tankRow + dr[dir];
                    int nc = tankCol + dc[dir];

                    while (nr >= 0 && nr < H && nc >= 0 && nc < W) {

                        // 강철 벽
                        if (board[nr][nc] == '#') {
                            break;
                        }

                        // 벽돌 벽
                        if (board[nr][nc] == '*') {
                            board[nr][nc] = '.';
                            break;
                        }

                        nr += dr[dir];
                        nc += dc[dir];
                    }

                    continue;
                }

                // 이동 명령
                for (int i = 0; i < 4; i++) {
                    if (c == commands[i]) {

                        dir = i;

                        // 방향 변경
                        board[tankRow][tankCol] = directions[dir];

                        int nr = tankRow + dr[dir];
                        int nc = tankCol + dc[dir];

                        // 이동 가능한 경우
                        if (nr >= 0 && nr < H &&
                            nc >= 0 && nc < W &&
                            board[nr][nc] == '.') {

                            board[tankRow][tankCol] = '.';

                            tankRow = nr;
                            tankCol = nc;

                            board[tankRow][tankCol] = directions[dir];
                        }

                        break;
                    }
                }
            }

            // 결과 출력
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}