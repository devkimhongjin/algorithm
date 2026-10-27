// JUNGOL #2711 · 볼링 점수
// https://jungol.co.kr/problem/2711
// Solved At: 2026-10-15 09:39:13 KST
// Language: Java
// Execution Time: 485 ms
// Memory: 39.3 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] pyramid = new int[N][N];
		int[][] dp = new int[N][N];

		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < i+1 ; j++){
				pyramid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = pyramid[0][0];
		int max = 0;
		for(int i = 1 ; i < N ; i++){
			for(int j = 0 ; j < i+1 ; j++){
				if(j == 0){
					dp[i][j] = pyramid[i][j] + dp[i-1][j];
				}else if(j == i){
					dp[i][j] = pyramid[i][j] + dp[i-1][j-1];
				}else{
					dp[i][j] = pyramid[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
				}
				if(i == N-1){
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}