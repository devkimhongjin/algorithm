// SWEA #7465 · 창용 마을 무리의 개수
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
// Language: JAVA
// Execution Time: 102 ms
// Memory: 27904 KB

//test
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
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 각 원소의 부모 노드를 저장
			parent = new int[N + 1];
			
			// 처음에는 모든 원소가 자기 자신을 대표 노드로 가짐
			for(int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			int cnt = 0;
			for(int i = 1 ; i <= N ; i++) {
				if(parent[i] == i) {
					cnt++;
				}
			}
			sb.append(cnt);
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}