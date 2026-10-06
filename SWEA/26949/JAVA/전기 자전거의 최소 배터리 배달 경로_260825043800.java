// SWEA #26949 · 전기 자전거의 최소 배터리 배달 경로
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpJdKHeHHBIQj
// Language: JAVA
// Execution Time: 231 ms
// Memory: 34688 KB

import java.io.*;
import java.util.*;

class Solution {

    static int N;
    static int[][] matrix;
    static int[][] dist;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int cost;

        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int calc() {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            int r = cur.r;
            int c = cur.c;
            int cost = cur.cost;

            if (cost > dist[r][c]) {
                continue;
            }

            if (r == N - 1 && c == N - 1) {
                return cost;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                int moveCost = 1;

                if (matrix[nr][nc] > matrix[r][c]) {
                    moveCost += matrix[nr][nc] - matrix[r][c];
                }

                int nextCost = cost + moveCost;

                if (nextCost < dist[nr][nc]) {

                    dist[nr][nc] = nextCost;

                    pq.offer(new Node(
                            nr,
                            nc,
                            nextCost
                    ));
                }
            }
        }

        return dist[N - 1][N - 1];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            matrix = new int[N][N];
            dist = new int[N][N];

            for (int r = 0; r < N; r++) {

                StringTokenizer st =
                        new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {
                    matrix[r][c] =
                            Integer.parseInt(st.nextToken());
                }
            }

            for (int[] row : dist) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            int result = calc();

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(result)
              .append("\n");
        }

        System.out.print(sb);
    }
}