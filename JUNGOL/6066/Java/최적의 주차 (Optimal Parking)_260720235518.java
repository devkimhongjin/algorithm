// JUNGOL #6066 · 최적의 주차 (Optimal Parking)
// https://jungol.co.kr/problem/6066
// Language: Java
// Execution Time: 90 ms
// Memory: 33 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());

                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            answer.append((max - min)*2)
                  .append('\n');
        }

        System.out.print(answer);
    }
}