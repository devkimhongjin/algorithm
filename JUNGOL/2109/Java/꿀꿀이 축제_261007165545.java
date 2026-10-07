// JUNGOL #2109 · 꿀꿀이 축제
// https://jungol.co.kr/problem/2109
// Solved At: 2026-10-07 16:55:45 KST
// Language: Java
// Execution Time: 215 ms
// Memory: 38304 MB

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static int[] dijkstra(int start, List<Node>[] graph) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.dist > dist[cur.to])
                continue;

            for (Node next : graph[cur.to]) {
                int newDist = cur.dist + next.dist;

                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.offer(new Node(next.to, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];
        List<Node>[] reverse = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
            reverse[to].add(new Node(from, cost));
        }

        int[] fromX = dijkstra(X, graph);
        int[] toX = dijkstra(X, reverse);

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, toX[i] + fromX[i]);
        }

        System.out.println(answer);
    }
}