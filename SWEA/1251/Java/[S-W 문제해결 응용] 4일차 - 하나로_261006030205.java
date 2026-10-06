// SWEA #1251 · [S/W 문제해결 응용] 4일차 - 하나로
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD
// Language: Java
// Execution Time: 634 ms
// Memory: 108436 KB

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int to;
    long cost;

    public Edge(int to, long cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.cost, o.cost);
    }
}

class Solution {

    // E를 여기서 곱하지 않고 거리의 제곱만 계산
    static long getCost(long x1, long y1, long x2, long y2) {
        long dx = x1 - x2;
        long dy = y1 - y2;

        return dx * dx + dy * dy;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            int[] x = new int[N];
            int[] y = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            // 그래프 생성
            List<Edge>[] graph = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 완전 그래프
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {

                    long cost = getCost(
                        x[i], y[i],
                        x[j], y[j]
                    );

                    graph[i].add(new Edge(j, cost));
                    graph[j].add(new Edge(i, cost));
                }
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N];

            pq.offer(new Edge(0, 0));

            long totalCost = 0;
            int count = 0;

            while (!pq.isEmpty()) {

                Edge cur = pq.poll();

                if (visited[cur.to]) {
                    continue;
                }

                visited[cur.to] = true;
                totalCost += cur.cost;
                count++;

                // N개의 정점을 모두 선택했다면 종료
                if (count == N) {
                    break;
                }

                for (Edge next : graph[cur.to]) {
                    if (!visited[next.to]) {
                        pq.offer(next);
                    }
                }
            }

            // MST 완성 후 환경 부담 세율 적용
            long answer = Math.round(totalCost * E);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
    }
}