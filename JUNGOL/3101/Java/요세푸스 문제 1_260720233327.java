// JUNGOL #3101 · 요세푸스 문제 1
// https://jungol.co.kr/problem/3101
// Language: Java
// Execution Time: 1194 ms
// Memory: 39.5 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out)
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

        while (size > 0) {
            for (int i = 0; i < k - 1; i++) {
                queue[rear % n] = queue[front % n];

                rear++;
                front++;
            }

            int removed = queue[front % n];
            front++;
            size--;

            bw.write(Integer.toString(removed));

            if (size > 0) {
                bw.write(' ');
            }
        }

        bw.flush();
    }
}