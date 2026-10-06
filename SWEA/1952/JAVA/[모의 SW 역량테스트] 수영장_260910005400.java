// SWEA #1952 · [모의 SW 역량테스트] 수영장
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq
// Language: JAVA
// Execution Time: 85 ms
// Memory: 26880 KB

import java.io.*;
import java.util.*;

class Solution {
	
	static int[] cost;
	static int[] days;
	
	static int minCost;
	
	static void dfs(int month, int totalCost) {
		if(totalCost >= minCost) {
			return;
		}
		if(month > 12) {
			minCost = Math.min(minCost, totalCost);
			return;
		}
		if(days[month] == 0) {
			dfs(month+1, totalCost);
		}
		
		dfs(month+3, totalCost + cost[2]);
		int oneMonthCost = Math.min(days[month] * cost[0], cost[1]);
		dfs(month+1, totalCost + oneMonthCost);
	}
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            cost = new int[4];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 4 ; i++) {
            	cost[i] = Integer.parseInt(st.nextToken());
            }
            days = new int[13];
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <=12 ; i++) {
            	days[i] = Integer.parseInt(st.nextToken());
            }
            
            minCost = cost[3];
            dfs(1, 0);
            
            sb.append(minCost)
              .append("\n");
        }

        System.out.print(sb);
    }
}