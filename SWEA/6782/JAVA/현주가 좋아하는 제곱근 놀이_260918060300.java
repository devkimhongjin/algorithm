// SWEA #6782 · 현주가 좋아하는 제곱근 놀이
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgqsAlKr9sDFAW0
// Language: JAVA
// Execution Time: 118 ms
// Memory: 32256 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	static boolean canRoot(long N) {
		return Math.sqrt(N) == (long)Math.sqrt(N);
	}
	
	static final int MAX_N_ROOT = 1000000;
	
	static long findNextSquare(long N) {
		return (long)Math.pow(Math.ceil(Math.sqrt(N)), 2);
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			long N = Long.parseLong(br.readLine());
			
			int cnt = 0;
			while(N != 2) {
				if(canRoot(N)) {
					cnt++;
					N = (long)Math.sqrt(N);
				}else {
					long nextSquare = findNextSquare(N);
					cnt += nextSquare - N;
					N = nextSquare;
				}
			}
			sb.append(cnt)
			  .append("\n");
			
		}
		
		System.out.print(sb);
	}
}