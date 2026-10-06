// JUNGOL #1338 · 문자삼각형1
// https://jungol.co.kr/problem/1338
// Language: Java
// Execution Time: 226 ms
// Memory: 33.1 MB

import java.io.*;

public class Main {

    static final char[] ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder(N * N * 2);

        for (int r = 1; r <= N; r++) {
            for (int space = 0; space < N - r; space++) {
                answer.append("  ");
            }

            int number = r;

            for (int c = 1; c <= r; c++) {
                answer.append(ALPHABETS[(number - 1) % 26]);

                if (c < r) {
                    answer.append(' ');
                }

                number += N - c;
            }

            answer.append('\n');
        }

        System.out.print(answer);
    }
}