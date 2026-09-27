// SWEA #4796 · 의석이의 우뚝 선 산
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWS2h6AKBCoDFAVT
// Language: Java
// Execution Time: 669 ms
// Memory: 102076 KB

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            int N = sc.nextInt();

            int answer = 0;
            int left = 0;
            int right = 0;
            int prevH = -1;
            boolean up = true;

            for (int i = 0; i < N; i++) {
                int h = sc.nextInt();

                if (up) {
                    if (h > prevH) {
                        left++;
                    } else {
                        up = false;
                        left--;
                        right++;
                    }
                } else {
                    if (h < prevH) {
                        right++;
                    } else {
                        up = true;
                        answer += left * right;
                        left = 2;
                        right = 0;
                    }
                }

                prevH = h;
            }

            answer += left * right;

            sb.append(answer)
              .append("\n");
        }

        System.out.print(sb);
        sc.close();
    }
}