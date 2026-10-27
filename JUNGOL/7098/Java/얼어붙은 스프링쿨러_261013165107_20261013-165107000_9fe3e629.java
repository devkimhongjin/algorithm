// JUNGOL #7098 · 얼어붙은 스프링쿨러
// https://jungol.co.kr/problem/7098
// Solved At: 2026-10-13 16:51:07 KST
// Language: Java
// Execution Time: 351 ms
// Memory: 36.4 MB

import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Edge>[] graph;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;

    static int dfs(int cur) {
        visited[cur] = true;

        int cost = 0;
        boolean isLeaf = true;

        for (Edge edge : graph[cur]) {
            int next = edge.to;
            int weight = edge.weight;

            if (visited[next]) continue;

            isLeaf = false;

            int childCost = dfs(next);

            cost += Math.min(weight, childCost);
        }

        if (isLeaf) return INF;

        return cost;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[u].add(new Edge(v, w));
                graph[v].add(new Edge(u, w));
            }

            int answer = dfs(C);

            sb.append(answer == INF ? 0 : answer).append("\n");
        }

        System.out.print(sb);
    }
}