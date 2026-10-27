// JUNGOL #1352 · 양팔저울
// https://jungol.co.kr/problem/1352
// Solved At: 2026-10-12 17:34:48 KST
// Language: Java
// Execution Time: 153 ms
// Memory: 34.4 MB


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] canMeasure = new boolean[40001];
        canMeasure[0] = true;

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            boolean[] next = canMeasure.clone();

            for (int j = 0; j <= sum; j++) {
                if (!canMeasure[j]) continue;

                next[Math.abs(j - input)] = true;
                next[j + input] = true;
            }

            sum += input;
            canMeasure = next;
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int weight = Integer.parseInt(st.nextToken());
            sb.append(weight <= sum && canMeasure[weight] ? "Y" : "N")
              .append(" ");
        }

        System.out.println(sb);
    }
}
