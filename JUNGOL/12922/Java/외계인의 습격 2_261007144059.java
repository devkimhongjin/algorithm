// JUNGOL #12922 · 외계인의 습격 2
// https://jungol.co.kr/problem/12922
// Solved At: 2026-10-07 14:40:59 KST
// Language: Java
// Execution Time: 954 ms
// Memory: 62316 MB

import java.io.*;
import java.util.*;

public class Main {

	static int[] parent;
	static int max = 0;

	static int find(int a){
		if(parent[a] < 0)
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);

		if(rootA == rootB)
			return;
		if(parent[rootA] <= parent[rootB]){
			parent[rootA] += parent[rootB];
			parent[rootB] = rootA;
			max = Math.max(max, -parent[rootA]);
		}else{
			parent[rootB] += parent[rootA];
			parent[rootA] = rootB;
			max = Math.max(max, -parent[rootB]);
		}
		
	}

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if(m == 0){
			System.out.print(1);
			return;
		}
		parent = new int[n+1];
		for(int i = 1 ; i <= n ; i++){
			parent[i] = -1;
		}
		for(int i = 0 ; i < m ; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		System.out.print(max);
		
	}
}