// SWEA #1486 · 장훈이의 높은 선반
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw
// Language: JAVA
// Execution Time: 76 ms
// Memory: 25728 KB

import java.io.*;
import java.util.*;

class Solution {
	
	static int N, S;
	static int answer;
    static int[] arr;
    
    static void dfs(int idx, int sum) {

        if (sum >= answer) {
            return;
        }

        if (sum >= S) {
            answer = sum;
            return;
        }

        if (idx == N) {
            return;
        }
        
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
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
        	
        	 st = new StringTokenizer(br.readLine());
        	 N = Integer.parseInt(st.nextToken());
        	 S = Integer.parseInt(st.nextToken());
             arr = new int[N];
             answer = Integer.MAX_VALUE;
             
             st = new StringTokenizer(br.readLine());
             for(int i = 0 ; i < N ; i++)
             {
            	 arr[i] = Integer.parseInt(st.nextToken());
             }
             
             
             dfs(0,0);
             sb.append(answer - S)
             .append("\n");
             
        }

        System.out.print(sb);
    }
}