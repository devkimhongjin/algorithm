// SWEA #3289 · 서로소 집합
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr
// Language: JAVA
// Execution Time: 437 ms
// Memory: 109672 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] parent;
	
	// a가 속한 그룹의 대표 노드를 반환
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		
		return parent[a] = find(parent[a]);
	}
	
	// a와 b가 속한 두 그룹을 하나로 합침
	static void union(int a, int b) {
		
		int rootA = find(a);
		int rootB = find(b);
		
		// 이미 같은 그룹이라면 합칠 필요 없음
		if(rootA == rootB) {
			return;
		}
		parent[rootB] = rootA;

	}
	
	// a와 b가 같은 그룹에 속해 있는지 확인
	static boolean isGrouped(int a, int b) {
		return find(a) == find(b);
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
			
			// 각 원소의 부모 노드를 저장
			parent = new int[n + 1];
			
			// 처음에는 모든 원소가 자기 자신을 대표 노드로 가짐
			for(int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			
			for(int i = 0; i < m; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// 0 : 두 원소가 속한 그룹을 합침
				if(command == 0) {
					union(a, b);
				}
				
				// 1 : 두 원소가 같은 그룹인지 확인
				if(command == 1) {
					if(isGrouped(a, b)) {
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