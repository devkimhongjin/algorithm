// SWEA #5215 · 햄버거 다이어트
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
// Language: JAVA
// Execution Time: 136 ms
// Memory: 26496 KB

import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int L;
    static int[][] TK;
    static int maxT;

    static void dfs(int index, int currentT, int currentK) {

        // 제한 칼로리를 초과한 경우 탐색 종료
        if (currentK > L) {
            return;
        }

        // 모든 재료를 확인한 경우
        if (index == N) {
            maxT = Math.max(maxT, currentT);
            return;
        }

        // 현재 재료를 선택하는 경우
        dfs(
            index + 1,
            currentT + TK[index][0],
            currentK + TK[index][1]
        );

        // 현재 재료를 선택하지 않는 경우
        dfs(index + 1, currentT, currentK);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            TK = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                TK[i][0] = Integer.parseInt(st.nextToken()); // 맛 점수
                TK[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
            }

            maxT = Integer.MIN_VALUE;

            dfs(0, 0, 0);

            sb.append("#")
              .append(testCase)
              .append(" ")
              .append(maxT)
              .append("\n");
        }

        System.out.print(sb);
    }
}