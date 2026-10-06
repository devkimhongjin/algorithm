// SWEA #1227 · [S/W 문제해결 기본] 7일차 - 미로2
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14wL9KAGkCFAYD
// Language: JAVA
// Execution Time: 99 ms
// Memory: 29568 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] board;
	static boolean[][] visited;
	
	static boolean canReach = false;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void dfs(int r, int c) {
		
		if(canReach) {
			return;
		}
		
		for(int i = 0 ; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(board[nr][nc] == 3) {
				canReach = true;
				return;
			}
			if(board[nr][nc] == 0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
				visited[nr][nc] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#").append(test_case).append(" ");

			br.readLine();
			
			final int N = 100;
			board = new int[N][N];
			visited = new boolean[N][N];
			
			int sRow=-1, sCol=-1;
			
			for(int i = 0 ; i < N ; i++) {
				String line = br.readLine();
				for(int j = 0 ; j < N ; j++) {
					int input = line.charAt(j) - '0';
					if(input == 2) {
						sRow = i;
						sCol = j;
					}
					board[i][j] = input;
				}
			}
			visited[sRow][sCol] = true;
			canReach = false;
			dfs(sRow, sCol);
			
			sb.append(canReach? 1 : 0)
			  .append("\n");
		}

		System.out.print(sb);
	}
}
