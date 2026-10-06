// JUNGOL #6327 · 스택 수열
// https://jungol.co.kr/problem/6327
// Language: Java
// Execution Time: 261 ms
// Memory: 33.3 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();

        String input = br.readLine();

        for (int i = 0; i < N; i++) {
            A[i] = input.charAt(i) - '0';
        }

        int n = 1;

        for (int i = 0; i < N; i++) {
            stack.push(A[i]);
            sb.append("push\n");

            while (!stack.isEmpty() && stack.peek() == n) {
                stack.pop();
                sb.append("pop\n");
                n++;
            }
        }
		
        if (!stack.isEmpty()) {
            sb.setLength(0);
            sb.append(-1);
        }

        System.out.print(sb);
    }
}