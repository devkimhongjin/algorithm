// SWEA #2105 · [모의 SW 역량테스트] 디저트 카페
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu
// Language: JAVA
// Execution Time: 115 ms
// Memory: 27776 KB

import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[][] map;

    static int result;

    static final int[] dr = {1, 1, -1, -1};
    static final int[] dc = {1, -1, -1, 1};


    static int[] visitedNumber = new int[101];
    static int visitStamp = 0;

    static boolean check(int startR, int startC, int a, int b) {

        visitStamp++;

        int r = startR;
        int c = startC;

        // 시작점 숫자 방문 처리
        visitedNumber[map[r][c]] = visitStamp;

        // 네 변의 길이
        int[] length = {a, b, a, b};

        for (int dir = 0; dir < 4; dir++) {

            for (int move = 0; move < length[dir]; move++) {

                r += dr[dir];
                c += dc[dir];

                /*
                 * 마지막 방향의 마지막 이동은
                 * 처음 시작했던 위치로 돌아오는 이동이다.
                 *
                 * 시작점 숫자는 이미 방문 처리되어 있으므로
                 * 여기서는 중복 검사하지 않는다.
                 */
                if (dir == 3 && move == length[dir] - 1) {
                    continue;
                }

                int number = map[r][c];

                // 현재 사각형에서 이미 먹은 숫자라면 실패
                if (visitedNumber[number] == visitStamp) {
                    return false;
                }

                visitedNumber[number] = visitStamp;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            result = -1;
            
            for (int r = 0; r < N - 2; r++) {
                for (int c = 1; c < N - 1; c++) {
                    int maxA = N - 1 - c;

                    for (int a = 1; a <= maxA; a++) {
                        int maxB = Math.min(
                                c,
                                N - 1 - r - a
                        );

                        if (maxB < 1) {
                            continue;
                        }

                        /*
                         * 현재 a에서 만들 수 있는 가장 큰 사각형조차
                         * 기존 정답보다 작거나 같다면 검사할 필요가 없다.
                         *
                         * 둘레의 칸 수 = 2 * (a + b)
                         */
                        if (2 * (a + maxB) <= result) {
                            continue;
                        }

                        /*
                         * 큰 b부터 검사한다.
                         *
                         * 큰 사각형을 먼저 발견하면 result가 빨리 커져
                         * 이후 작은 후보들을 더 많이 가지치기할 수 있다.
                         */
                        for (int b = maxB; b >= 1; b--) {

                            int count = 2 * (a + b);

                            // 현재 최고 기록보다 작거나 같은 후보는 생략
                            if (count <= result) {
                                break;
                            }

                            if (check(r, c, a, b)) {
                                result = count;

                                /*
                                 * 현재 a에서는 b를 큰 값부터 보고 있으므로,
                                 * 첫 성공 이후 더 작은 b는
                                 * count가 작아질 뿐이다.
                                 */
                                break;
                            }
                        }
                    }
                }
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(result)
              .append("\n");
        }

        System.out.print(sb);
    }
}