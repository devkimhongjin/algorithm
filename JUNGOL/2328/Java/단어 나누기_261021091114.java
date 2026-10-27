// JUNGOL #2328 · 단어 나누기
// https://jungol.co.kr/problem/2328
// Solved At: 2026-10-21 09:11:14 KST
// Language: Java
// Execution Time: 237 ms
// Memory: 34.1 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String s = br.readLine();
        String answer = null;
        int n = s.length();

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = new StringBuilder(s.substring(0, i))
                    .reverse().toString();
                String b = new StringBuilder(s.substring(i, j))
                    .reverse().toString();
                String c = new StringBuilder(s.substring(j))
                    .reverse().toString();

                String candidate = a + b + c;

                if (answer == null || candidate.compareTo(answer) < 0) {
                    answer = candidate;
                }
            }
        }

        System.out.println(answer);
    }
}