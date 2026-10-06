// SWEA #6782 · 현주가 좋아하는 제곱근 놀이
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgqsAlKr9sDFAW0
// Language: JAVA
// Execution Time: 129 ms
// Memory: 39928 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	static final int MAX_N_ROOT = 1000000;
	static long[] dp = new long[MAX_N_ROOT + 1];
	
	static boolean canRoot(long N) {
		long root = (long) Math.sqrt(N);
		return root * root == N;
	}
	
	static long findNextSquare(long N) {
		long root = (long) Math.sqrt(N);
		
		if(root * root < N) {
			root++;
		}
		
		return root * root;
	}
	
	static void makeDP() {
		dp[2] = 0;
		
		for(int i = 3; i <= MAX_N_ROOT; i++) {
			
			long root = (long) Math.sqrt(i);
			
			// 제곱수라면 바로 제곱근으로 이동
			if(root * root == i) {
				dp[i] = 1 + dp[(int) root];
			}
			
			// 제곱수가 아니라면 다음 제곱수까지 증가 후 제곱근
			else {
				root++;
				
				long nextSquare = root * root;
				
				dp[i] = (nextSquare - i)
						+ 1
						+ dp[(int) root];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		
		StringBuilder sb = new StringBuilder();
		
		makeDP();

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			long N = Long.parseLong(br.readLine());
			
			long cnt = 0;
			
			// DP 범위까지 N을 줄임
			while(N > MAX_N_ROOT) {
				
				if(canRoot(N)) {
					cnt++;
					N = (long) Math.sqrt(N);
				}
				else {
					long nextSquare = findNextSquare(N);
					cnt += nextSquare - N;
					N = nextSquare;
				}
			}
			
			// 나머지는 미리 계산한 DP 사용
			cnt += dp[(int) N];
			
			sb.append(cnt)
			  .append("\n");
		}
		
		System.out.print(sb);
	}
}