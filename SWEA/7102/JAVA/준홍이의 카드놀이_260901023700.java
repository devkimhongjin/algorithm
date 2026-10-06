// SWEA #7102 · 준홍이의 카드놀이
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIlHWqBYcDFAXC
// Language: JAVA
// Execution Time: 79 ms
// Memory: 24704 KB

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			Map<Integer, Integer> map  = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == M) {
				sb.append(N+1)
				  .append(" ");
			}else {
				if(N > M) {
					for(int i = 1 ; i <= N-M+1 ; i++) {
						sb.append(M+i)
						  .append(" ");
					}
				}else {
					for(int i = 1 ; i <= M-N+1 ; i++) {
						sb.append(N+i)
						  .append(" ");
					}
				}
			}

			sb.append("\n");
		}

		System.out.print(sb);
	}
}