// SWEA #3282 · 0/1 Knapsack
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJAVpqrzQDFAWr
// Solved At: 2026-10-13 11:36:36 KST
// Language: Java
// Execution Time: 85 ms
// Memory: 25600 KB

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= T ; tc++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	int[][] arr = new int[N][2];
        	int[] dp = new int[K+1];
        	for(int i = 0 ; i < N ; i++) {
        		st = new StringTokenizer(br.readLine());
        		int v = Integer.parseInt(st.nextToken());
        		int k = Integer.parseInt(st.nextToken());
        		arr[i][0] = v;
        		arr[i][1] = k;
        	}
        	for(int i = 0 ; i < N ; i++) {
        		for(int j = K ; j >= arr[i][0] ; j--) {
        			dp[j] = Math.max(dp[j], dp[j-arr[i][0]] + arr[i][1]);
        		}
        	}
        	sb.append("#")
        	  .append(tc)
        	  .append(" ")
        	  .append(dp[K])
        	  .append("\n");
        }
        System.out.println(sb);
    }
}