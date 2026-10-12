// SWEA #7733 · 치즈 도둑
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWrDOdQqRCUDFARG
// Solved At: 2026-09-16 11:57:00 KST
// Language: JAVA
// Execution Time: 347 ms
// Memory: 49300 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[][] cheese;
	static boolean[][] visited;
	static HashMap<Integer, List<Loc>> cheeseMap;
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
    
	static class Loc{
		int r;
		int c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean eatCheese(int taste) {
		List<Loc> locationList = cheeseMap.get(taste);
		if(locationList == null) {
			return false;
		}
		for(Loc l : locationList) {
			cheese[l.r][l.c] = 0;
		}
		return true;
	}
	
	static void countCheese(int r, int c) {
		visited[r][c] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || cheese[nr][nc] == 0) {
				continue;
			}
			countCheese(nr, nc);
		}
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
        	
            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];
            cheeseMap = new HashMap<>();
            int maxTaste = 0;
            
            for(int i = 0 ; i < N ; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0 ; j < N ; j++) {
            		int input = Integer.parseInt(st.nextToken());
            		cheese[i][j] = input;
            		cheeseMap.computeIfAbsent(input, k -> new ArrayList<>())
            				 .add(new Loc(i, j));
            		maxTaste = Math.max(maxTaste, input);
            	}
            }
            int maxCount = 1;
            for(int t = 1 ; t < maxTaste ; t++) {
            	if(eatCheese(t)) {
            		int count = 0;
                	visited = new boolean[N][N];
                	for(int i = 0 ; i < N ; i++) {
                		for(int j = 0 ; j < N ; j++) {
                			if(visited[i][j] || cheese[i][j] == 0) {
                				continue;
                			}
                			count++;
                			countCheese(i, j);
                		}
                	}
                	maxCount = Math.max(maxCount, count);
            	}
            }
            sb.append(maxCount)
              .append("\n");
            
        }
        
        System.out.print(sb);
    }
}