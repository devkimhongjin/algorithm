// JUNGOL #2283 · RGB 마을
// https://jungol.co.kr/problem/2283
// Solved At: 2026-11-12 17:18:24 KST
// Language: Java
// Execution Time: 436 ms
// Memory: 33676 KiB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][3];
		int[][] minCost = new int[N][3];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
			if(i==0){
				minCost[i][0] = house[i][0];
				minCost[i][1] = house[i][1];
				minCost[i][2] = house[i][2];
			}else{
				minCost[i][0] = house[i][0]
								+ Math.min(minCost[i-1][1], minCost[i-1][2]);
				minCost[i][1] = house[i][1]
								+ Math.min(minCost[i-1][0], minCost[i-1][2]);
				minCost[i][2] = house[i][2]
								+ Math.min(minCost[i-1][0], minCost[i-1][1]);		
			}
		}

		int min = Math.min(Math.min(minCost[N-1][0], minCost[N-1][1]), minCost[N-1][2]);
		System.out.print(min);
	}
}