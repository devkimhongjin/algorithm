// SWEA #2072 · 홀수만 더하기
// https://swexpertacademy.com/main/code/problem/problemList.do
// Solved At: 2026-09-03 16:59:37 KST
// Language: JAVA

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;

            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());

                if (num % 2 != 0) {
                    sum += num;
                }
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(sum)
              .append("\n");
        }

        System.out.print(sb);
    }
}