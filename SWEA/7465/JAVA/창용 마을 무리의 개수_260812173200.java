// SWEA #7465 · 창용 마을 무리의 개수
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
// Solved At: 2026-08-12 17:32:00 KST
// Language: JAVA
// Execution Time: 108 ms
// Memory: 28928 KB

import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                graph[n1].add(n2);
                graph[n2].add(n1);
            }

            boolean[] visited = new boolean[N + 1];
            int answer = 0;

            Deque<Integer> queue = new ArrayDeque<>();

            for (int i = 1; i <= N; i++) {
                if (visited[i]) {
                    continue;
                }

                answer++;

                visited[i] = true;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int cur = queue.poll();

                    for (int next : graph[cur]) {
                        if (visited[next]) {
                            continue;
                        }

                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}