// JUNGOL #3101 · 요세푸스 문제 1
// https://jungol.co.kr/problem/3101
// Language: Java
// Execution Time: 1006 ms
// Memory: 44.2 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int front = queue.poll();
                queue.offer(front);
            }

            int removed = queue.poll();
            sb.append(removed);

            if (!queue.isEmpty()) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}