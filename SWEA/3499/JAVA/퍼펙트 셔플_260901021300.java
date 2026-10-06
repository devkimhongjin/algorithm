// SWEA #3499 · 퍼펙트 셔플
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
// Language: JAVA
// Execution Time: 96 ms
// Memory: 30464 KB

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			int N = Integer.parseInt(br.readLine());

			// 카드 덱을 두 묶음으로 나눌 때 첫 번째 묶음의 크기
			// N이 홀수라면 첫 번째 묶음이 한 장 더 많도록 설정
			int half = N % 2 == 0 ? N / 2 : N / 2 + 1;

			// 앞쪽 카드 묶음
			String[] firstHalf = new String[half];

			// 뒤쪽 카드 묶음
			String[] secondHalf = new String[N - half];

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 입력받은 카드들을 앞/뒤 두 묶음으로 나누어 저장
			for (int i = 0; i < N; i++) {
				String input = st.nextToken();

				if (i < half) {
					firstHalf[i] = input;
				} else {
					secondHalf[i - half] = input;
				}
			}

			// 첫 번째 묶음과 두 번째 묶음의 카드를 번갈아 출력
			for (int i = 0; i < half; i++) {
				sb.append(firstHalf[i])
				  .append(" ");

				// N이 홀수인 경우 첫 번째 묶음에 카드가 한 장 더 있으므로
				// 마지막 카드까지 출력했다면 반복 종료
				if (half > secondHalf.length && i == half - 1) {
					break;
				}

				sb.append(secondHalf[i])
				  .append(" ");
			}

			sb.append("\n");
		}

		System.out.print(sb);
	}
}