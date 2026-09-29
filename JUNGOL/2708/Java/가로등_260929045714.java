// JUNGOL #2708 · 가로등
// https://jungol.co.kr/problem/2708
// Language: Java
// Execution Time: 549 ms
// Memory: 59436 MB

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;
	
	static class Edge {
		int s;
		int e;
		int d;
		
		public Edge(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b] = a;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[N];
		
		int total = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(s, e, d);
			total += d;
		}
		
		// 간선 비용 기준 오름차순 정렬
		Arrays.sort(edges, (a, b) -> a.d - b.d);
		
		// Union-Find 초기화
		parent = new int[M];
		
		for(int i = 0; i < M; i++) {
			parent[i] = i;
		}
		
		int mstCost = 0;
		int edgeCount = 0;
		
		// Kruskal
		for(Edge edge : edges) {
			
			// 이미 연결되어 있으면 사이클이 생기므로 사용하지 않음
			if(find(edge.s) == find(edge.e)) {
				continue;
			}
			
			union(edge.s, edge.e);
			mstCost += edge.d;
			edgeCount++;
			
			// MST는 정점 M개라면 간선 M-1개
			if(edgeCount == M - 1) {
				break;
			}
		}
		
		// 전체 가로등 비용 - 최소한으로 필요한 가로등 비용
		System.out.print(total - mstCost);
	}
}