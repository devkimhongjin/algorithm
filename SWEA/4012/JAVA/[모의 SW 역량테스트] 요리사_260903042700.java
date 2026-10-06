// SWEA #4012 · [모의 SW 역량테스트] 요리사
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
// Language: JAVA
// Execution Time: 96 ms
// Memory: 27392 KB

import java.io.*;
import java.util.*;

class Solution {

	static int N;
	static int[] taste;
	static int totalTaste;
	static int minDiff;

	static void dfs(int cur, int count, int sum) {

		// N/2개를 모두 선택한 경우
		if(count == N / 2) {
			minDiff = Math.min(
				minDiff,
				Math.abs(sum - totalTaste)
			);
			return;
		}

		// 남은 식재료를 전부 골라도 N/2개를 만들 수 없는 경우
		if(N - cur < N / 2 - count) {
			return;
		}

		// 모든 식재료를 확인한 경우
		if(cur == N) {
			return;
		}

		// 현재 식재료 선택
		dfs(cur + 1, count + 1, sum + taste[cur]);

		// 현재 식재료 선택하지 않음
		dfs(cur + 1, count, sum);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			int[][] synergy = new int[N][N];

			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for(int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			taste = new int[N];
			totalTaste = 0;
			minDiff = Integer.MAX_VALUE;

			// 각 식재료가 다른 모든 식재료와 만드는 시너지 합 계산
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {

					int pairTaste =
						synergy[i][j] + synergy[j][i];

					taste[i] += pairTaste;
					taste[j] += pairTaste;

					// 모든 식재료 쌍의 시너지 합
					totalTaste += pairTaste;
				}
			}

			// A/B가 뒤바뀐 경우는 동일하므로
			// 0번 식재료를 A에 고정
			dfs(1, 1, taste[0]);

			sb.append("#")
			  .append(tc)
			  .append(" ")
			  .append(minDiff)
			  .append("\n");
		}

		System.out.print(sb);
	}
}