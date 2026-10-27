// JUNGOL #1077 · 배낭채우기1
// https://jungol.co.kr/problem/1077
// Solved At: 2026-10-12 16:50:57 KST
// Language: Java
// Execution Time: 221 ms
// Memory: 34 MB

import java.io.*;
import java.util.*;

class Jewel{
	int weight;
	int price;
	public Jewel(int weight, int price) {
		super();
		this.weight = weight;
		this.price = price;
	}
}

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Jewel[] jewels = new Jewel[N];
		
		int W = Integer.parseInt(st.nextToken());
		int[] dp = new int[W+1];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(weight, price);
		}
		
		for (Jewel jewel : jewels) {
		    for (int w = jewel.weight; w <= W; w++) {
		        dp[w] = Math.max(
		            dp[w],
		            dp[w - jewel.weight] + jewel.price
		        );
		    }
		}

		System.out.println(dp[W]);
	}
}