// SWEA #3421 · 수제 버거 장인
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWErcQmKy6kDFAXi
// Solved At: 2026-09-08 12:14:00 KST
// Language: JAVA
// Execution Time: 130 ms
// Memory: 27620 KB

import java.io.*;
import java.util.*;

class Solution {

    static int N;
    static boolean[][] check;
    static int[] blocked;
    static int answer;

    static void dfs(int index) {

        if (index == N) {
            answer++;
            return;
        }

        // 현재 재료를 선택하지 않는 경우
        dfs(index + 1);

        // 앞에서 선택한 재료 때문에 현재 재료를 사용할 수 없다면 종료
        if (blocked[index] > 0) {
            return;
        }

        // 현재 재료를 선택
        // 현재 재료와 함께 사용할 수 없는 재료들을 막아둠
        for (int i = index + 1; i < N; i++) {
            if (check[index][i]) {
                blocked[i]++;
            }
        }

        dfs(index + 1);

        // 원상복구
        for (int i = index + 1; i < N; i++) {
            if (check[index][i]) {
                blocked[i]--;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            check = new boolean[N][N];
            blocked = new int[N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                check[a][b] = true;
                check[b][a] = true;
            }

            answer = 0;
            dfs(0);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
    }
}