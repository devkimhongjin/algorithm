// SWEA #1251 · [S/W 문제해결 응용] 4일차 - 하나로
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD
// Solved At: 2026-10-06 03:14:31 UTC
// Language: Java
// Execution Time: 615 ms
// Memory: 97148 KB

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int from, to;
    long cost;

    public Edge(int from, int to, long cost) {
    	this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.cost, o.cost);
    }
}

class Solution {
	
	static int[] parent;
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return false;
		parent[aRoot] = bRoot;
		return true;
	}

    static long getCost(long x1, long y1, long x2, long y2) {
        long dx = x1 - x2;
        long dy = y1 - y2;

        return dx * dx + dy * dy;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            int[] x = new int[N];
            int[] y = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());
            
            parent = new int[N];
            for(int i = 0 ; i < N ; i++) {
            	parent[i] = i;
            }
            List<Edge> edgeList = new ArrayList<>();
            
            for(int i = 0 ; i < N-1 ; i++) {
            	for(int j = i+1 ; j < N ; j++) {
            		edgeList.add(new Edge(i, j, getCost(x[i], y[i], x[j], y[j])));
            	}
            }
            
            Collections.sort(edgeList);
            
            long totalCost = 0;
            int count = 0;
            
            for(Edge e : edgeList) {
            	if(union(e.from, e.to)) {
            		count++;
            		totalCost += e.cost;
            	}
            	if(count == N-1)
            		break;
            }
            

            

            // MST 완성 후 환경 부담 세율 적용
            long answer = Math.round(totalCost * E);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
    }
}