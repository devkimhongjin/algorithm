// SWEA #14510 · 나무 높이
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AYFofW8qpXYDFAR4
// Language: JAVA
// Execution Time: 87 ms
// Memory: 25728 KB

import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		// 테스트 케이스 반복
		for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
			// 나무의 개수 입력
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			// Collections.reverseOrder()를 사용하기 위해 Integer 배열로 선언
			Integer[] trees = new Integer[N];

			// 높이를 1만큼 증가시켜야 하는 횟수
			int one = 0;

			// 높이를 2만큼 증가시켜야 하는 횟수
			int two = 0;

			// 나무 높이 입력
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
			}

			// 가장 높은 나무를 첫 번째 원소로 배치
			Arrays.sort(trees, Collections.reverseOrder());

			// 모든 나무가 도달해야 하는 목표 높이
			int maxHeight = trees[0];

			// 각 나무와 최대 높이의 차이를 1 증가 작업과 2 증가 작업으로 분해
			for (int i = 1; i < N; i++) {

				int heightDiff = maxHeight - trees[i];

				// 높이 차이가 홀수라면 1 증가 작업이 한 번 필요
				one += heightDiff % 2;

				// 나머지 높이 차이는 2 증가 작업으로 처리
				two += heightDiff / 2;
			}

			// 모든 나무의 높이를 맞추는 데 필요한 최소 일수
			int answer = 0;

			/*
			 * 1 증가 작업과 2 증가 작업의 횟수가 같은 경우
			 *
			 * 작업 순서: 1, 2, 1, 2, ...
			 *
			 * 두 작업을 쉬는 날 없이 번갈아 사용할 수 있으므로
			 * 최소 일수 = one + two
			 */
			if (one == two) {
				answer = one + two;
			}

			/*
			 * 1 증가 작업이 더 많은 경우
			 *
			 * 먼저 two개의 1 증가 작업과 2 증가 작업을 번갈아 처리한다.
			 * 이후 남은 1 증가 작업은 이틀마다 한 번씩 처리할 수 있다.
			 *
			 * 최소 일수
			 * = (two × 2) + ((one - two) × 2) - 1
			 * = one × 2 - 1
			 *
			 * 마지막 1 증가 작업 뒤에는 하루를 더 기다릴 필요가 없으므로
			 * 전체 일수에서 1을 뺀다.
			 */
			else if (one > two) {
				answer = one * 2 - 1;
			}

			/*
			 * 2 증가 작업이 더 많은 경우
			 *
			 * 2 증가 작업 하나는 1 증가 작업 두 번으로 대체할 수 있다.
			 * 따라서 남는 2 증가 작업을 일부 변환하여
			 * 1 증가 작업과 2 증가 작업의 균형을 맞춘다.
			 *
			 * 남는 2 증가 작업 수
			 * = two - one
			 *
			 * 추가로 필요한 일수
			 * = (two - one - 1) / 3 + 1
			 *
			 * 최소 일수
			 * = one + two + (two - one - 1) / 3 + 1
			 */
			else {
				answer = one + two + (two - one - 1) / 3 + 1;
			}
        	sb.append(answer)
               .append("\n");
		}
		System.out.print(sb);
	}
}