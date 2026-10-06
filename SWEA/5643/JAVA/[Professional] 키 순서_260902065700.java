// SWEA #5643 · [Professional] 키 순서
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo
// Language: JAVA
// Execution Time: 297 ms
// Memory: 96808 KB

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

			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			BitSet[] connected = new BitSet[N];

			for (int i = 0; i < N; i++) {
				connected[i] = new BitSet(N);

				// 자기 자신과는 연결된 것으로 처리
				connected[i].set(i);
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;

				connected[a].set(b);
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (connected[i].get(k)) {
						connected[i].or(connected[k]);
					}
				}
			}

			int answer = 0;

			for (int i = 0; i < N; i++) {
				boolean canKnowAll = true;

				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}

					if (!connected[i].get(j)
							&& !connected[j].get(i)) {

						canKnowAll = false;
						break;
					}
				}

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