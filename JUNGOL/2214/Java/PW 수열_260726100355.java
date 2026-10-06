// JUNGOL #2214 · PW 수열
// https://jungol.co.kr/problem/2214
// Language: Java
// Execution Time: 135 ms
// Memory: 33.5 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder parentheses = new StringBuilder();

        int previousOpenCount = 0;

        for (int i = 0; i < n; i++) {
            int newOpenCount = p[i] - previousOpenCount;

            for (int j = 0; j < newOpenCount; j++) {
                parentheses.append('(');
            }

            parentheses.append(')');

            previousOpenCount = p[i];
        }

        String s = parentheses.toString();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ')') {
                continue;
            }

            int balance = 1;
            int pairCount = 1;

            for (int j = i - 1; j >= 0; j--) {

                if (s.charAt(j) == ')') {
                    balance++;
                    pairCount++;
                } else {
                    balance--;
                }

                if (balance == 0) {
                    break;
                }
            }

            answer.append(pairCount).append(' ');
        }

        System.out.println(answer.toString().trim());
    }
}