// SWEA #1249 · [S/W 문제해결 응용] 4일차 - 보급로
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD
// Language: JAVA
// Execution Time: 159 ms
// Memory: 30416 KB

import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};

	static int[][] costs;
	static int[][] dist;

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
			return this.cost - o.cost;
		}
	}

	static int dijkstra() {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		dist[0][0] = 0;
		pq.offer(new Node(0, 0, 0));

		while (!pq.isEmpty()) {

			Node cur = pq.poll();

			// 이미 더 짧은 경로로 방문한 경우
			if (cur.cost > dist[cur.r][cur.c]) {
				continue;
			}

			// 목적지에 가장 작은 비용으로 도착
			if (cur.r == N - 1 && cur.c == N - 1) {
				return cur.cost;
			}

			for (int i = 0; i < 4; i++) {

				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}

				int nextCost = cur.cost + costs[nr][nc];

				// 기존에 알고 있던 비용보다 더 작은 경우 갱신
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

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(br.readLine());

			costs = new int[N][N];

			for (int i = 0; i < N; i++) {

				String line = br.readLine();

				for (int j = 0; j < N; j++) {
					costs[i][j] = line.charAt(j) - '0';
				}
			}

			sb.append("#")
			  .append(test_case)
			  .append(" ")
			  .append(dijkstra())
			  .append("\n");
		}

		System.out.print(sb);
	}
}