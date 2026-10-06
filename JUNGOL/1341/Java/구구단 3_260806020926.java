// JUNGOL #1341 · 구구단 3
// https://jungol.co.kr/problem/1341
// Language: Java
// Execution Time: 220 ms
// Memory: 38.7 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int direction = A <= B ? 1 : -1;

        for (int i = A; ; i += direction) {
            for (int j = 1; j <= 9; j++) {
                answer.append(i)
                      .append(" * ")
                      .append(j)
                      .append(" = ")
                      .append(String.format("%2d", i * j));

                if (j % 3 == 0) {
                    answer.append("\n");
                } else {
                    answer.append("   ");
                }
            }

            answer.append("\n");

            if (i == B) {
                break;
            }
        }

        System.out.print(answer);
    }
}