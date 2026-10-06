// JUNGOL #1544 · 회장뽑기
// https://jungol.co.kr/problem/1544
// Language: Java
// Execution Time: 254 ms
// Memory: 33 MB

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<Integer>[] graph;

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        q.offer(start);
        visited[start] = true;

        int maxDist = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    maxDist = Math.max(maxDist, dist[next]);

                    q.offer(next);
                }
            }
        }

        return maxDist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (i == -1 && j == -1) {
                break;
            }

            graph[i].add(j);
            graph[j].add(i);
        }

        int minDist = Integer.MAX_VALUE;
        List<Integer> starts = new ArrayList<>();

        for (int start = 1; start <= N; start++) {
            int maxDist = bfs(start);

            if (maxDist < minDist) {
                minDist = maxDist;

                starts.clear();
                starts.add(start);

            } else if (maxDist == minDist) {
                starts.add(start);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(minDist)
          .append(" ")
          .append(starts.size())
          .append("\n");

        for (int start : starts) {
            sb.append(start).append(" ");
        }

        System.out.println(sb);
    }
}