// JUNGOL #2000 · 동전교환
// https://jungol.co.kr/problem/2000
// Language: Java
// Execution Time: 307 ms
// Memory: 34.3 MB

import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] dp;
	static int[] coins;

	static void func(int w){
		for(int i = 1 ; i <= w ; i++){
			int minCoin = Integer.MAX_VALUE;
			for(int j = 0 ; j < N ; j++){
				int prevDP = i - coins[j];
				if(prevDP >= 0 && dp[prevDP] != -1){
					minCoin = Math.min(minCoin, dp[prevDP]);
				}
			}
			if(minCoin == Integer.MAX_VALUE){
				dp[i] = -1;
			}else{
				dp[i] = minCoin + 1;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		coins = new int[N];
		for(int i = 0 ; i < N ; i++){
			coins[i] = Integer.parseInt(st.nextToken());
		}
		int W = Integer.parseInt(br.readLine());
		dp = new int[W+1];
		dp[0] = 0;

		func(W);

		System.out.print(dp[W] == -1? "impossible" : dp[W]);
	}
}