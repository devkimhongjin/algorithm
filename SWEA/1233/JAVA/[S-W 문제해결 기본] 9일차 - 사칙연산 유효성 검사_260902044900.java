// SWEA #1233 · [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
// Language: JAVA
// Execution Time: 84 ms
// Memory: 25216 KB

import java.io.*;
import java.util.*;

public class Solution {

	static boolean isOperator(String s) {
		return s.equals("+")
			|| s.equals("-")
			|| s.equals("*")
			|| s.equals("/");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			int answer = 1;
			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 다음 테스트 케이스를 위해 입력은 다 받음
				if (answer == 0) {
					continue;
				}
				
				// 노드 번호 날리기
				st.nextToken();	
				String input = st.nextToken();
				
				// 내부 노드는 연산자여야 함
				if (i < N / 2) {
					if (!isOperator(input)) {
						answer = 0;
					}
				}
				// 리프 노드는 숫자여야 함
				else {
					if (isOperator(input)) {
						answer = 0;
					}
				}
			}

			sb.append(answer)
			  .append("\n");
		}

		System.out.print(sb);
	}
}
