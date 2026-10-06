// JUNGOL #3553 · 최대 합
// https://jungol.co.kr/problem/3553
// Language: Java
// Execution Time: 239 ms
// Memory: 37 MB

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] dp = new boolean[2][M];

		// 아무것도 선택하지 않은 상태
		dp[0][0] = true;

		for (int num : nums) {
			boolean[][] next = new boolean[2][M];

			for (int remainder = 0; remainder < M; remainder++) {

				// 현재 원소를 선택하지 않는 경우
				if (dp[0][remainder]) {
					next[0][remainder] = true;
				}

				if (dp[1][remainder]) {
					next[0][remainder] = true;
				}

				// 현재 원소를 선택하는 경우
				// 직전 원소가 선택되지 않았을 때만 가능
				if (dp[0][remainder]) {
					int nextRemainder
						= (remainder + num) % M;

					next[1][nextRemainder] = true;
				}
			}

			dp = next;
		}

		int answer = 0;

		for (int remainder = M - 1; remainder >= 0; remainder--) {
			if (dp[0][remainder] || dp[1][remainder]) {
				answer = remainder;
				break;
			}
		}

		System.out.println(answer);
	}
}