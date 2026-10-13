// PROGRAMMERS #72413 · 합승 택시 요금
// https://school.programmers.co.kr/learn/courses/30/lessons/72413
// Solved At: 2026-10-13 13:47:34 KST
// Language: Java

import java.util.*;

class Solution {

    static class Edge implements Comparable<Edge> {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<Edge>[] graph;
    static final int INF = Integer.MAX_VALUE;

    static int[] dijkstra(int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Edge next : graph[cur.to]) {
                int newCost = cur.cost + next.cost;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Edge(next.to, newCost));
                }
            }
        }

        return dist;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];

            graph[u].add(new Edge(v, cost));
            graph[v].add(new Edge(u, cost));
        }

        int[] distS = dijkstra(n, s);
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);

        int answer = INF;

        for (int k = 1; k <= n; k++) {
            int total = distS[k] + distA[k] + distB[k];
            answer = Math.min(answer, total);
        }

        return answer;
    }
}