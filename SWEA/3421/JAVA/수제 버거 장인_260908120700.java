// SWEA #3421 · 수제 버거 장인
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWErcQmKy6kDFAXi
// Solved At: 2026-09-08 12:07:00 KST
// Language: JAVA
// Execution Time: 371 ms
// Memory: 32576 KB

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
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] forbidden = new int[M][2];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                forbidden[i][0] = Integer.parseInt(st.nextToken()) - 1;
                forbidden[i][1] = Integer.parseInt(st.nextToken()) - 1;
            }

            int answer = 0;

            // 0 ~ (2^N - 1) : N개 원소로 만들 수 있는 모든 부분집합
            for (int mask = 0; mask < (1 << N); mask++) {

                boolean possible = true;

                // 입력받은 금지 조합이 현재 부분집합에 포함되어 있는지 확인
                for (int i = 0; i < M; i++) {
                    int a = forbidden[i][0];
                    int b = forbidden[i][1];

                    // a와 b가 둘 다 포함되어 있으면 불가능한 조합
                    if ((mask & (1 << a)) != 0 &&
                        (mask & (1 << b)) != 0) {

                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}