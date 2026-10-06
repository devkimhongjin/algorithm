// JUNGOL #4181 · 순열정복 5
// https://jungol.co.kr/problem/4181
// Language: Java
// Execution Time: 445 ms
// Memory: 36.6 MB

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, S;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int sum) {

        if (depth == M) {
            if (sum == S) {
                for (int num : result) {
                    sb.append(num).append(' ');
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = 1; i <= N; i++) {

            if (sum + i > S) {
                break;
            }

            result[depth] = i;
            dfs(depth + 1, sum + i);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        result = new int[M];

        dfs(0, 0);

        System.out.print(sb);
    }
}