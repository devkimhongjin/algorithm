// SWEA #7465 · 창용 마을 무리의 개수
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
// Language: JAVA
// Execution Time: 101 ms
// Memory: 28032 KB

import java.io.*;
import java.util.*;

class Solution {

	static boolean[] visited;
	static boolean[][] check;

	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());

        	visited = new boolean[N+1];
        	check = new boolean[N+1][N+1];
        	
        	for(int i = 0 ; i < M ; i++) {
        		st = new StringTokenizer(br.readLine());
        		int n1 = Integer.parseInt(st.nextToken());
            	int n2 = Integer.parseInt(st.nextToken());
            	check[n1][n2] = true;
            	check[n2][n1] = true;
        	}
        	int answer = 0;
        	Deque<Integer> queue= new ArrayDeque<>();;
        	for(int i = 1 ; i <= N ; i++) {
        		if(visited[i]) {
        			continue;
        		}
        		answer++;
        		queue.offer(i);
        		while(!queue.isEmpty()) {
        			int cur = queue.poll();
        			for(int j = 0  ; j <= N ; j++) {
        				if(check[cur][j] && !visited[j]) {
        					visited[j] = true;
        					queue.offer(j);
        				}
        			}
        		}
        	}

        	System.out.println("#" + tc + " " + answer);
        }
    }
}