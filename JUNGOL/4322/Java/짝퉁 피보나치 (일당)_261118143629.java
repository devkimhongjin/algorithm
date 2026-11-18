// JUNGOL #4322 · 짝퉁 피보나치 (일당)
// https://jungol.co.kr/problem/4322
// Solved At: 2026-11-18 14:36:29 KST
// Language: Java
// Execution Time: 294 ms
// Memory: 34708 KiB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{

		int[] A = new int[100001];
		int[] max = new int[100001];
		A[1] = 1;
		A[2] = 1; max[2] = 1;
		for(int i = 3 ; i <= 100000 ; i++){
			if(i % 2 == 1){
				A[i] = A[i/2]+A[i/2+1];
			}else{
				A[i] = A[i/2];
			}
			max[i] = Math.max(max[i-1], A[i]);
		}
		
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		int N;
		while(true){
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			System.out.println(max[N]);
		}
	}
}