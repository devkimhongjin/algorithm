// SWEA #7102 · 준홍이의 카드놀이
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIlHWqBYcDFAXC
// Language: JAVA
// Execution Time: 113 ms
// Memory: 27776 KB

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			// 두 주사위의 합을 key, 해당 합이 나오는 횟수를 value로 저장
			Map<Integer, Integer> map  = new HashMap<>();

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 첫 번째 주사위의 면 개수
			int N = Integer.parseInt(st.nextToken());

			// 두 번째 주사위의 면 개수
			int M = Integer.parseInt(st.nextToken());
			
			// 두 주사위에서 나올 수 있는 모든 경우의 수 탐색
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {

					// 두 주사위 눈의 합
					int sum = i + j;

					// 해당 합이 등장한 횟수 1 증가
					map.put(sum, map.getOrDefault(sum, 0) + 1);
				}
			}
			
			// 가장 많이 등장한 횟수 찾기
			int maxValue = Collections.max(map.values());

			// 가장 많이 등장한 합들을 모두 출력
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() == maxValue) {
					sb.append(entry.getKey())
					  .append(" ");
				}
			}

			sb.append("\n");
		}

		System.out.print(sb);
	}
}