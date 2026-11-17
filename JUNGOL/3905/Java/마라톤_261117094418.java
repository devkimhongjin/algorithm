// JUNGOL #3905 · 마라톤
// https://jungol.co.kr/problem/3905
// Solved At: 2026-11-17 09:44:18 KST
// Language: Java
// Execution Time: 766 ms
// Memory: 63308 KiB

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] checkpoints;
    static int[][] dist;

    static class Node implements Comparable<Node> {
        int idx;
        int dist;
        int skipped;

        public Node(int idx, int dist, int skipped) {
            this.idx = idx;
            this.dist = dist;
            this.skipped = skipped;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static int getDistance(int a, int b) {
        return Math.abs(checkpoints[a][0] - checkpoints[b][0])
             + Math.abs(checkpoints[a][1] - checkpoints[b][1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        N = Integer.parseInt(br.readLine());
        checkpoints = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            checkpoints[i][0] = Integer.parseInt(st.nextToken());
            checkpoints[i][1] = Integer.parseInt(st.nextToken());
        }

        dist = new int[N][2];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int idx = cur.idx;
            int cost = cur.dist;
            int skipped = cur.skipped;

            if (cost > dist[idx][skipped]) continue;

            if (idx == N - 1) {
                System.out.println(cost);
                return;
            }

            if (idx + 1 < N) {
                int nextCost = cost + getDistance(idx, idx + 1);

                if (nextCost < dist[idx + 1][skipped]) {
                    dist[idx + 1][skipped] = nextCost;
                    pq.offer(new Node(idx + 1, nextCost, skipped));
                }
            }

            if (idx + 2 < N && skipped == 0) {
                int nextCost = cost + getDistance(idx, idx + 2);

                if (nextCost < dist[idx + 2][1]) {
                    dist[idx + 2][1] = nextCost;
                    pq.offer(new Node(idx + 2, nextCost, 1));
                }
            }
        }
    }
}