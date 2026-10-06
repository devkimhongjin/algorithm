// SWEA #27020 · 인접 구역 색칠 경우의 수
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87c1z6yFHHBITH
// Language: JAVA
// Execution Time: 86 ms
// Memory: 25728 KB

import java.io.*;
import java.util.*;

class Solution {

	static int N;
	static int K;
	static boolean[][] graph;
	static int[] colors;
	static long answer;

	static void dfs(int currentNode) {

		if(currentNode > N) {
			answer++;
			return;
		}

		for(int color = 1 ; color <= K ; color++) {

			boolean canUse = true;

			for(int adjacentNode = 1 ; adjacentNode <= N ; adjacentNode++) {

				if(graph[currentNode][adjacentNode]
						&& colors[adjacentNode] == color) {

					canUse = false;
					break;
				}
			}

			if(!canUse) {
				continue;
			}

			colors[currentNode] = color;

			dfs(currentNode + 1);

			colors[currentNode] = 0;
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1 ; tc <= T ; tc++) {

			sb.append("#")
			  .append(tc)
			  .append(" ");

			StringTokenizer st =
					new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			graph = new boolean[N + 1][N + 1];

			for(int i = 0 ; i < M ; i++) {

				st = new StringTokenizer(br.readLine());

				int nodeA = Integer.parseInt(st.nextToken());
				int nodeB = Integer.parseInt(st.nextToken());

				graph[nodeA][nodeB] = true;
				graph[nodeB][nodeA] = true;
			}

			colors = new int[N + 1];
			answer = 0;

			dfs(1);

			sb.append(answer)
			  .append("\n");
		}

        
		System.out.print(sb);
	}
}