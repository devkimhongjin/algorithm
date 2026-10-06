// SWEA #3421 · 수제 버거 장인
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWErcQmKy6kDFAXi
// Language: JAVA
// Execution Time: 120 ms
// Memory: 27264 KB

import java.io.*;
import java.util.*;

class Solution {

    static int N;
    static boolean[][] check;
    static boolean[] selected;
    static int answer;

    static void dfs(int idx) {

        // N개의 재료에 대해 선택이 모두 끝남
        if (idx == N) {
            answer++;
            return;
        }

        // 1. 현재 재료를 선택하지 않는 경우
        dfs(idx + 1);

        // 2. 현재 재료를 선택할 수 있는지 확인
        for (int i = 0; i < idx; i++) {
            if (selected[i] && check[idx][i]) {
                return;
            }
        }

        // 현재 재료 선택
        selected[idx] = true;
        dfs(idx + 1);
        selected[idx] = false;
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
            selected = new boolean[N];

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