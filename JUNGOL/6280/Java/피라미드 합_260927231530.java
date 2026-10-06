// JUNGOL #6280 · 피라미드 합
// https://jungol.co.kr/problem/6280
// Language: Java
// Execution Time: 474 ms
// Memory: 33.7 MB

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    static int[] coefficients;
    static int[] bottom;
    static boolean[] visited;

    static boolean found = false;

    static void dfs(int depth, int sum) {
        if (found) {
            return;
        }

        if (depth == N) {
            if (sum == K) {
                StringBuilder answer = new StringBuilder();

                for (int number : bottom) {
                    answer.append(number).append(' ');
                }

                System.out.println(answer.toString().trim());
                found = true;
            }

            return;
        }

        for (int number = 1; number <= N; number++) {
            if (visited[number]) {
                continue;
            }

            int nextSum = sum + number * coefficients[depth];

            if (nextSum > K) {
                continue;
            }

            visited[number] = true;
            bottom[depth] = number;

            dfs(depth + 1, nextSum);

            visited[number] = false;
        }
    }

    static void makeCoefficients() {
        coefficients = new int[N];
        coefficients[0] = 1;

        for (int i = 1; i < N; i++) {
            coefficients[i] =
                    coefficients[i - 1] * (N - i) / i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bottom = new int[N];
        visited = new boolean[N + 1];

        makeCoefficients();
        dfs(0, 0);
    }
}