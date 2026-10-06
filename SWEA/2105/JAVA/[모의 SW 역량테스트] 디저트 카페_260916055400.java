// SWEA #2105 · [모의 SW 역량테스트] 디저트 카페
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu
// Language: JAVA
// Execution Time: 154 ms
// Memory: 56740 KB

import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[][] store;

    static final int MAX_NUMBER = 100;

    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};

    static boolean check(int startR, int startC, int a, int b) {

        boolean[] visitedNumber = new boolean[MAX_NUMBER + 1];

        int r = startR;
        int c = startC;

        visitedNumber[store[r][c]] = true;

        // 각 방향으로 이동할 거리
        int[] length = {a, b, a, b};

        for (int dir = 0; dir < 4; dir++) {

            for (int move = 0; move < length[dir]; move++) {

                r += dr[dir];
                c += dc[dir];

                // 범위를 벗어나면 불가능
                if (r < 0 || r >= N || c < 0 || c >= N) {
                    return false;
                }

                // 마지막 이동은 시작점으로 돌아오는 이동
                if (dir == 3 && move == length[dir] - 1) {
                    return r == startR && c == startC;
                }

                int number = store[r][c];

                // 같은 디저트를 이미 먹은 경우
                if (visitedNumber[number]) {
                    return false;
                }

                visitedNumber[number] = true;
            }
        }

        return false;
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
            store = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    store[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = -1;

            // 대각사각형의 가장 위쪽 꼭짓점
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    // 첫 번째 변 길이
                    for (int a = 1; a < N; a++) {

                        // 두 번째 변 길이
                        for (int b = 1; b < N; b++) {


                            // 가장 아래까지 내려갔을 때
                            if (r + a + b >= N) {
                                continue;
                            }

                            // 오른쪽 꼭짓점
                            if (c + a >= N) {
                                continue;
                            }

                            // 왼쪽 꼭짓점
                            if (c - b < 0) {
                                continue;
                            }

                            if (check(r, c, a, b)) {
                                answer = Math.max(
                                        answer,
                                        2 * (a + b)
                                );
                            }
                        }
                    }
                }
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
    }
}