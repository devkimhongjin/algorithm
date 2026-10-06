// JUNGOL #1831 · 품평회 행사
// https://jungol.co.kr/problem/1831
// Language: Java
// Execution Time: 242 ms
// Memory: 40.4 MB

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer>[] graph = new ArrayList[200001];

		int maxEndTime = Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int endTime = T+L;
			if(graph[endTime] == null){
				graph[endTime] = new ArrayList<>();
			}
			graph[endTime].add(T);
			maxEndTime = Math.max(maxEndTime, endTime);
		}

		int[] dp = new int[maxEndTime+1];
		dp[0] = 0;	

		for(int i = 1 ; i <= maxEndTime ; i++){
			dp[i] = dp[i-1];
			if(graph[i] != null){
				for(int n : graph[i]){
					dp[i] = Math.max(dp[i], dp[n]+1);
				}
			}
		}

		System.out.print(dp[maxEndTime]);
	}
}