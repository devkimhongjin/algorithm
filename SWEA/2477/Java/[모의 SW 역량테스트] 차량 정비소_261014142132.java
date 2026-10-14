// SWEA #2477 · [모의 SW 역량테스트] 차량 정비소
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV6c6bgaIuoDFAXy
// Solved At: 2026-10-14 14:21:32 KST
// Language: Java
// Execution Time: 187 ms
// Memory: 35284 KB

import java.io.*;
import java.util.*;

public class Solution {

    static class Customer {
        int id, time, desk;

        Customer(int id, int time, int desk) {
            this.id = id;
            this.time = time;
            this.desk = desk;
        }
    }

    static void assign(
        PriorityQueue<Customer> waiting,
        int[] duration,
        int[] available,
        int[] usedDesk,
        PriorityQueue<Customer> next
    ) {
        while (!waiting.isEmpty()) {
            Customer c = waiting.poll();

            int selected = -1;
            int earliest = Integer.MAX_VALUE;

            for (int i = 0; i < duration.length; i++) {
                int start = Math.max(c.time, available[i]);

                if (start < earliest) {
                    earliest = start;
                    selected = i;
                }
            }

            available[selected] = earliest + duration[selected];
            usedDesk[c.id] = selected;

            if (next != null) {
                next.offer(new Customer(
                    c.id, available[selected], selected
                ));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            int[] a = new int[N];
            int[] b = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                a[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                b[i] = Integer.parseInt(st.nextToken());

            PriorityQueue<Customer> reception = new PriorityQueue<>(
                (x, y) -> {
                    if (x.time != y.time)
                        return Integer.compare(x.time, y.time);
                    return Integer.compare(x.id, y.id);
                }
            );

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                reception.offer(new Customer(
                    i, Integer.parseInt(st.nextToken()), -1
                ));
            }

            PriorityQueue<Customer> repair = new PriorityQueue<>(
                (x, y) -> {
                    if (x.time != y.time)
                        return Integer.compare(x.time, y.time);
                    return Integer.compare(x.desk, y.desk);
                }
            );

            int[] usedA = new int[K + 1];
            int[] usedB = new int[K + 1];

            assign(reception, a, new int[N], usedA, repair);
            assign(repair, b, new int[M], usedB, null);

            int answer = 0;

            for (int i = 1; i <= K; i++) {
                if (usedA[i] == A && usedB[i] == B)
                    answer += i;
            }

            sb.append("#").append(tc).append(" ")
              .append(answer == 0 ? -1 : answer)
              .append("\n");
        }

        System.out.print(sb);
    }
}