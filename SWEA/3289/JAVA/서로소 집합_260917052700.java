// SWEA #3289 · 서로소 집합
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr
// Language: JAVA
// Execution Time: 529 ms
// Memory: 108716 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] parent;
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			return;
		}
		
		if(rootA > rootB) {
			parent[rootB] = rootA;
		}else {
			parent[rootA] = rootB;
		}
	}
	static boolean isGrouped(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			for(int i = 1; i < n ; i++) {
				parent[i] = i;
			}
			
			for(int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(command == 0) {
					union(a,b);
				}
				if(command == 1) {
					if(isGrouped(a,b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}