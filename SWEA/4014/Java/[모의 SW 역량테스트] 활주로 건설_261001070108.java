// SWEA #4014 · [모의 SW 역량테스트] 활주로 건설
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeW7FakkUDFAVH
// Language: Java
// Execution Time: 104 ms
// Memory: 27264 KB

import java.io.*;
import java.util.*;

class Solution {

    static int N, X;
    static int[][] grid;

    // 한 줄에 활주로를 만들 수 있는지 확인
    static boolean isValid(int[] line) {

        // 현재 높이가 연속된 칸 수
        int streak = 1;

        for (int i = 1; i < N; i++) {

            // 같은 높이
            if (line[i] == line[i - 1]) {
                streak++;
                continue;
            }

            // 높이 차이가 2 이상이면 불가능
            if (Math.abs(line[i] - line[i - 1]) > 1) {
                return false;
            }

            // 올라가는 경사로
            if (line[i] == line[i - 1] + 1) {

                // 이전 높이가 X칸 이상 연속되어 있어야 함
                if (streak < X) {
                    return false;
                }

                streak = 1;
            }

            // 내려가는 경사로
            else {

                // 앞으로 X칸이 현재 낮은 높이와 같아야 함
                int height = line[i];

                for (int j = i; j < i + X; j++) {
                    if (j >= N || line[j] != height) {
                        return false;
                    }
                }

                // 경사로가 차지한 부분은 다시 사용할 수 없음
                i += X - 1;
                streak = 0;
            }
        }

        return true;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            grid = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            // 행 검사
            for (int r = 0; r < N; r++) {

                int[] line = new int[N];

                for (int c = 0; c < N; c++) {
                    line[c] = grid[r][c];
                }

                if (isValid(line)) {
                    answer++;
                }
            }

            // 열 검사
            for (int c = 0; c < N; c++) {

                int[] line = new int[N];

                for (int r = 0; r < N; r++) {
                    line[r] = grid[r][c];
                }

                if (isValid(line)) {
                    answer++;
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