// SWEA #2806 · N-Queen
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GKs06AU0DFAXB
// Language: JAVA
// Execution Time: 79 ms
// Memory: 25344 KB

import java.io.*;

class Solution {

    static int N;
    static int count;

    // 같은 열에 퀸이 있는지
    static boolean[] col;
    static boolean[] diagonal1;
    static boolean[] diagonal2;

    static void dfs(int row) {

        // 모든 행에 퀸을 하나씩 배치했다면 성공
        if (row == N) {
            count++;
            return;
        }

        // 현재 row에서 퀸을 놓을 열 선택
        for (int c = 0; c < N; c++) {

            int d1 = row - c + N - 1;
            int d2 = row + c;

            // 같은 열 또는 같은 대각선에 퀸이 있으면 배치 불가능
            if (col[c] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            // 퀸 배치
            col[c] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            // 다음 행으로 이동
            dfs(row + 1);

            // 원상 복구
            col[c] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            count = 0;

            col = new boolean[N];

            // 가능한 대각선 개수는 2N - 1
            diagonal1 = new boolean[2 * N - 1];
            diagonal2 = new boolean[2 * N - 1];

            dfs(0);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(count)
              .append("\n");
        }

        System.out.print(sb);
    }
}