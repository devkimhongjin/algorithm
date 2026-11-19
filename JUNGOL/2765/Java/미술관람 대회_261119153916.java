// JUNGOL #2765 · 미술관람 대회
// https://jungol.co.kr/problem/2765
// Solved At: 2026-11-19 15:39:16 KST
// Language: Java
// Execution Time: 259 ms
// Memory: 34284 KiB

import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static String[] board;
	static boolean[][] visited;
	static char color;

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	static void dfs(int r, int c, boolean isColorBlind){
		visited[r][c] = true;
		for(int i = 0 ; i < 4 ; i++){
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]){
				continue;
			}
			char nColor = board[nr].charAt(nc);
			
			if(nColor == color ||
				(isColorBlind && (
					(color=='R' && nColor=='G')
					||(color=='G' && nColor=='R')
					)
				)
			){
				dfs(nr, nc, isColorBlind);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		N = Integer.parseInt(br.readLine());
		board = new String[N];
		for(int i = 0 ; i < N ; i++){
			board[i] = br.readLine();
		}

		int count = 0;
		visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				if(!visited[i][j]){
					count++;
					color = board[i].charAt(j);
					dfs(i, j, false);
				}
			}
		}

		System.out.print(count + " ");

		count = 0;
		visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				if(!visited[i][j]){
					count++;
					color = board[i].charAt(j);
					dfs(i, j, true);
				}
			}
		}

		System.out.print(count);
	}
}