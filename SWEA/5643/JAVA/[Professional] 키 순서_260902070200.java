// SWEA #5643 · [Professional] 키 순서
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo
// Language: JAVA
// Execution Time: 895 ms
// Memory: 102252 KB

import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);

		int T = Integer.parseInt(br.readLine());
		StringBuilder output = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {

			// 학생 수
			int N = Integer.parseInt(br.readLine());

			// 키 비교 횟수
			int M = Integer.parseInt(br.readLine());

			/*
			 * connected[i][j] == true
			 * -> i번 학생보다 j번 학생이 크다는 것을 알 수 있음
			 */
			boolean[][] connected = new boolean[N][N];

			// 자기 자신은 알고 있는 것으로 처리
			for (int i = 0; i < N; i++) {
				connected[i][i] = true;
			}

			// 직접 주어진 키 비교 관계 저장
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;

				// a보다 b가 큼
				connected[a][b] = true;
			}

			/*
			 * 플로이드-워셜
			 *
			 * i < k 이고 k < j 라면
			 * i < j 관계도 알 수 있음
			 */
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {

					// i -> k 관계가 없다면
					// k를 거쳐 갈 수 없으므로 생략
					if (!connected[i][k]) {
						continue;
					}

					for (int j = 0; j < N; j++) {

						if (connected[k][j]) {
							connected[i][j] = true;
						}
					}
				}
			}

			int answer = 0;

			// 각 학생의 정확한 순위를 알 수 있는지 확인
			for (int i = 0; i < N; i++) {
				boolean canKnowAll = true;

				for (int j = 0; j < N; j++) {

					if (i == j) {
						continue;
					}

					/*
					 * i < j도 아니고
					 * j < i도 아니라면
					 *
					 * i와 j의 키 관계를 알 수 없음
					 */
					if (!connected[i][j]
							&& !connected[j][i]) {

						canKnowAll = false;
						break;
					}
				}

				// 모든 학생과의 키 관계를 알 수 있다면
				// 자신의 정확한 순위를 알 수 있음
				if (canKnowAll) {
					answer++;
				}
			}

			output.append('#')
				  .append(test_case)
				  .append(' ')
				  .append(answer)
				  .append('\n');
		}

		System.out.print(output);
	}
}