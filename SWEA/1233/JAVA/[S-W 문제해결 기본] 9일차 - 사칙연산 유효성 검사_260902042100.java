// SWEA #1233 · [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
// Language: JAVA
// Execution Time: 87 ms
// Memory: 26368 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	static boolean isNum(char c) {
		if(c == '+' || c == '-' || c == '*' || c == '/') {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int answer = 1;
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st;
			char[] e = new char[N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				e[i] = st.nextToken().charAt(0);
			}
			
			for(int i = 0 ; i < N/2 ; i++) {
				if(isNum(e[i])) {
					if(isNum(e[i*2]) && isNum(e[i*2 + 1])) {
						answer = 0;
						break;
					}
				}
			}
			for(int i = N/2 + 1 ; i < N ; i++) {
				if(!isNum(e[i])) {
					answer = 0;
					break;
				}
			}
			
			sb.append(answer)
			  .append("\n");
		}

		System.out.print(sb);
	}
}
