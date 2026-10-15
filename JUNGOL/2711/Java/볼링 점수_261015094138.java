// JUNGOL #2711 · 볼링 점수
// https://jungol.co.kr/problem/2711
// Solved At: 2026-10-15 09:41:38 KST
// Language: Java
// Execution Time: 385 ms
// Memory: 39920 MB

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
		int max = 0;
		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < i+1 ; j++){
				pyramid[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0)
					continue;
				if(j == 0){
					pyramid[i][j] = pyramid[i][j] + pyramid[i-1][j];
				}else if(j == i){
					pyramid[i][j] = pyramid[i][j] + pyramid[i-1][j-1];
				}else{
					pyramid[i][j] = pyramid[i][j] + Math.max(pyramid[i-1][j], pyramid[i-1][j-1]);
				}
				if(i == N-1){
					max = Math.max(max, pyramid[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}