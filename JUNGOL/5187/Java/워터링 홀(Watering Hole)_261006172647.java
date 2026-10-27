// JUNGOL #5187 · 워터링 홀(Watering Hole)
// https://jungol.co.kr/problem/5187
// Solved At: 2026-10-06 17:26:47 KST
// Language: Java
// Execution Time: 390 ms
// Memory: 46.5 MB

import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        int[] W = new int[N];

        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(br.readLine());
        }

        List<Edge>[] graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());

                if (i == j)
                    continue;

                graph[i].add(new Edge(j, cost));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];

        // 각 정점에 직접 연결하는 비용을 초기 후보로 넣음
        for (int i = 0; i < N; i++) {
            pq.offer(new Edge(i, W[i]));
        }

        int cost = 0;
        int count = 0;

        while (!pq.isEmpty() && count < N) {

            Edge cur = pq.poll();

            if (visited[cur.to])
                continue;

            visited[cur.to] = true;
            cost += cur.cost;
            count++;

            for (Edge next : graph[cur.to]) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }

        System.out.print(cost);
    }
}