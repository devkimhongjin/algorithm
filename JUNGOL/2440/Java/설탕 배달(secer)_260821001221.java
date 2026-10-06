// JUNGOL #2440 · 설탕 배달(secer)
// https://jungol.co.kr/problem/2440
// Language: Java
// Execution Time: 173 ms
// Memory: 33 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];

		if(N == 3 || N == 5){
			answer = 1;
		}else if(N == 4){
			answer = -1;
		}else{
			Arrays.fill(dp, -1);
			dp[3] = 1;
			dp[4] = -1;
			dp[5] = 1;
			for(int i = 6 ; i <=N ; i++){
				int a = dp[i-3];
				int b = dp[i-5];
				if(a == -1 && b == -1){
					continue;
				}else{
					if(a == -1){
						dp[i] = b + 1;
					}else if(b == -1){
						dp[i] = a + 1;
					}else{
						dp[i] = Math.min(a,b) + 1;
					}
				}

			}
			answer = dp[N];
		}
		System.out.print(answer);
		
	}
}