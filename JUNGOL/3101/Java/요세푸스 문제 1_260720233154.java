// JUNGOL #3101 · 요세푸스 문제 1
// https://jungol.co.kr/problem/3101
// Language: Java
// Execution Time: 926 ms
// Memory: 36.4 MB

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

        int[] queue = new int[n];

        for (int i = 0; i < n; i++) {
            queue[i] = i + 1;
        }

        int front = 0;
        int rear = n;
        int size = n;

        StringBuilder sb = new StringBuilder();

        while (size > 0) {
            for (int i = 0; i < k - 1; i++) {
                queue[rear % n] = queue[front % n];
                front++;
                rear++;
            }

            int removed = queue[front % n];
            front++;
            size--;

            sb.append(removed);

            if (size > 0) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}