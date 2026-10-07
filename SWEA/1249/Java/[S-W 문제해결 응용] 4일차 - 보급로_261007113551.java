// SWEA #1249 · [S/W 문제해결 응용] 4일차 - 보급로
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD
// Solved At: 2026-10-07 11:35:51 KST
// Language: Java
// Execution Time: 113 ms
// Memory: 30592 KB

import java.io.*;
import java.util.*;

class Solution {
	
	static class Node implements Comparable<Node>{
		int r, c, dist;

		public Node(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}

	}

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            
            int[][] grid = new int[N][N];
            int[][] dist = new int[N][N];
            
            for (int i = 0; i < N; i++) {
            	String line = br.readLine();
            	for(int j = 0 ; j < N ; j++) {
            		grid[i][j] = line.charAt(j) - '0';
            		dist[i][j] = Integer.MAX_VALUE;
            	}
            }
            
            PriorityQueue<Node> pq = new PriorityQueue<>();
            dist[0][0] = 0;
            pq.offer(new Node(0, 0, 0));
            int answer = 0;
            
            while(!pq.isEmpty()) {
            	Node cur = pq.poll();
            	
            	if(cur.r == N-1 && cur.c == N-1) {
            		answer = cur.dist;
            		break;
            	}
            	
            	for(int i = 0 ; i < 4 ; i++) {
            		int nr = cur.r + dr[i];
            		int nc = cur.c + dc[i];
            		if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
            			continue;
            		}
            		int nextDist = cur.dist + grid[nr][nc];
            		if(nextDist < dist[nr][nc]) {
            			dist[nr][nc] = nextDist;
            			pq.offer(new Node(nr, nc, nextDist));
            		}
            		
            	}
            }


            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
    }
}