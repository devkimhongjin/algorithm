// JUNGOL #1929 · 책꽂이 만들기
// https://jungol.co.kr/problem/1929
// Language: Java
// Execution Time: 243 ms
// Memory: 37.1 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        long cost = 0;

        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();

            long sum = a + b;

            cost += sum;
            pq.offer(sum);
        }

        System.out.print(cost);
    }
}