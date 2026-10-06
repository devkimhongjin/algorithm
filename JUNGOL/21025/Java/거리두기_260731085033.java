// JUNGOL #21025 · 거리두기
// https://jungol.co.kr/problem/21025
// Language: Java
// Execution Time: 411 ms
// Memory: 33.4 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}
		int index = 0;
		while(index < N-1){
			if(A[index+1] - A[index] >= K){
				index++;
			}
			else{
				A[index]--;
				if(index > 0){
					index--;
				}
			}
		}

		for(int a : A){
			System.out.print(a + " ");
		}
	}
}