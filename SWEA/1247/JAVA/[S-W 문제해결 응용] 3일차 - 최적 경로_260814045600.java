// SWEA #1247 · [S/W 문제해결 응용] 3일차 - 최적 경로
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
// Language: JAVA
// Execution Time: 241 ms
// Memory: 26880 KB

import java.io.*;
import java.util.*;

class Solution {
	
	static int minDist;
	static int N;
	static boolean[] visited;
	static Location start;
	static Location end;
	static Location[] locations;

	static void dfs(int depth, int prevIdx, int dist) {
		if(dist >= minDist) {
			return;
		}
	    if (depth == N) {
	        dist += distance(locations[prevIdx], end);
	        minDist = Math.min(minDist, dist);
	        return;
	    }

	    for (int i = 0; i < N; i++) {
	        if (visited[i]) continue;

	        visited[i] = true;

	        int nextDist;

	        if (prevIdx == -1) {
	            nextDist = dist + distance(start, locations[i]);
	        } else {
	            nextDist = dist + distance(locations[prevIdx], locations[i]);
	        }

	        dfs(depth + 1, i, nextDist);

	        visited[i] = false;
	    }
	}
	
	static class Location {
		int x;
		int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int distance(Location l1, Location l2) {
		return Math.abs(l1.x - l2.x) + Math.abs(l1.y - l2.y);
	}
	
	
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	minDist = Integer.MAX_VALUE;
        	N = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	locations = new Location[N];
        	visited = new boolean[N];
        	
        	int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		start = new Location(x, y);
    		
    		x = Integer.parseInt(st.nextToken());
    		y = Integer.parseInt(st.nextToken());
    		end = new Location(x, y);
        	
        	for(int i = 0 ; i < N ; i++) {
        		x = Integer.parseInt(st.nextToken());
        		y = Integer.parseInt(st.nextToken());
        		locations[i] = new Location(x, y);
        	}

    		dfs(0, -1, 0);
    		
    		sb.append("#" + tc + " " + minDist).append("\n");
        }
        System.out.print(sb);
    }
}