// JUNGOL #3946 · 품종 세기
// https://jungol.co.kr/problem/3946
// Solved At: 2026-11-11 09:12:57 KST
// Language: Java
// Execution Time: 1620 ms
// Memory: 70972 KiB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[][] cows = new int[N+1][3];

		for(int i = 1; i <= N; i++){
			int n = Integer.parseInt(br.readLine());

			for(int j = 0; j < 3; j++){
				cows[i][j] = cows[i-1][j];
			}

			cows[i][n-1]++;
		}


		for(int i = 0 ; i < Q ; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) -1;
			int end = Integer.parseInt(st.nextToken());

			for(int j = 0 ; j < 3 ; j++){
				sb.append(cows[end][j] - cows[start][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}